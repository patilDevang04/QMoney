
package com.crio.warmup.stock.quotes;

import org.springframework.web.client.RestTemplate;

public enum StockQuoteServiceFactory {

  INSTANCE;

  

  public StockQuotesService getService(String provider,  RestTemplate restTemplate) {
    switch ((provider!=null)?provider.toLowerCase():"alphavantage") {
      case "tiingo":
        return new TiingoService(restTemplate);
      default:
        return new AlphavantageService(restTemplate);
      }
  }
}
