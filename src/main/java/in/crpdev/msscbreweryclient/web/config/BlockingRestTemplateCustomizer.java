package in.crpdev.msscbreweryclient.web.config;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultConnectionKeepAliveStrategy;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateCustomizer;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * Created by rajapandian
 * Date: 03/08/20
 * Project: mssc-brewery-client
 * Package: in.crpdev.msscbreweryclient.web.config
 **/
@Component
public class BlockingRestTemplateCustomizer implements RestTemplateCustomizer {

    private final Integer totalThreads;
    private final Integer totalConnections;
    private final Integer socketTimeout;
    private final Integer connectionTimeout;

    public BlockingRestTemplateCustomizer(@Value("${mssc.http.totalThreads}") Integer totalThreads,
                                          @Value("${mssc.http.totalConnections}") Integer totalConnections,
                                          @Value("${mssc.http.socketTimeout}") Integer socketTimeout,
                                          @Value("${mssc.http.connectionTimeout}") Integer connectionTimeout) {
        this.totalThreads = totalThreads;
        this.totalConnections = totalConnections;
        this.socketTimeout = socketTimeout;
        this.connectionTimeout = connectionTimeout;
    }

    private ClientHttpRequestFactory clientHttpRequestFactory(){
        PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager();
        connectionManager.setMaxTotal(totalThreads);
        connectionManager.setDefaultMaxPerRoute(totalConnections);

        RequestConfig requestConfig = RequestConfig.custom()
                .setConnectTimeout(connectionTimeout)
                .setSocketTimeout(socketTimeout)
                .build();

        CloseableHttpClient httpClient = HttpClients
                .custom()
                .setConnectionManager(connectionManager)
                .setKeepAliveStrategy(new DefaultConnectionKeepAliveStrategy())
                .setDefaultRequestConfig(requestConfig)
                .build();

        return new HttpComponentsClientHttpRequestFactory(httpClient);
    }

    @Override
    public void customize(RestTemplate restTemplate) {
        System.out.println("<<< Using custom HTTP client >>>");
        restTemplate.setRequestFactory(this.clientHttpRequestFactory());
    }
}
