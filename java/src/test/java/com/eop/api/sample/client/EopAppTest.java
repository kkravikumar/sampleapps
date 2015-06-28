package com.eop.api.sample.client;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.eop.api.ApiClient;
import com.eop.api.OfferApi;
import com.eop.api.io.Geo;
import com.eop.api.io.GeoAttribute;
import com.eop.api.io.Offer;
import com.eop.api.io.SearchRequest;


/**
 * Test cases for EOP application.
 */
public class EopAppTest {
  
    private ApiClient apiClient = new ApiClient();
    
    @Test
    public void testGetOfferDetails() {
        String offerId = "afe5c6f2-efa5-4e68-84f0-6aa86738a32b";
        String response = apiClient.getOfferDetails(offerId);
        Assert.assertNotNull(response);
        Assert.assertTrue(response.contains("<ResponseCode>200</ResponseCode>"));
        System.out.println(response);
    }
    
    @Test
    public void testGetRedemptionCodes() {
        String offerId = "d4f9fccf-31be-442e-bdaf-44aaeb55791d";
        String response = apiClient.getRedemptionCodes(offerId);
        Assert.assertNotNull(response);
        Assert.assertTrue(response.contains("<GetRedemptionCodesResponse>"));
        System.out.println(response);
    }

    @Test
    public void testGetOfferInventory() {
        String offerId = "d4f9fccf-31be-442e-bdaf-44aaeb55791d";
        String response = apiClient.getOfferInventory(offerId);
        Assert.assertNotNull(response);
        Assert.assertTrue(response.contains("<ResponseCode>200</ResponseCode>"));
        System.out.println(response);
    }
    
    @Test
    public void testUpdateOfferInventory() {
        String offerId = "d4f9fccf-31be-442e-bdaf-44aaeb55791d";
        int redeemedQuantity = 1;
        String response = apiClient.updateInventory(offerId, redeemedQuantity);
        Assert.assertNotNull(response);
        Assert.assertTrue(response.contains("<ResponseCode>200</ResponseCode>"));
        System.out.println(response);
    }

    
    @Test
    public void testGetRecentOffers() {
        Integer hours = 24;
        String response = apiClient.getRecentOffers(hours);
        Assert.assertNotNull(response);
        Assert.assertTrue(response.contains("<GetRecentOfferIdsResponse>"));
        System.out.println(response);
    }
    
    @Test
    public void testSearchOffers() {
        
      String searchKey = "limited";  
      SearchRequest searchRequest = new SearchRequest();
      searchRequest.setProgram("priceless");
      searchRequest.setKeywords(searchKey);

      String response = apiClient.getSearchOffers(searchRequest);
      Assert.assertTrue(response.contains("<ResponseCode>200</ResponseCode>"));
      System.out.println(response);
    }

    
    @Test
    public void testSearchOffersByProductCodes() {
        
      String searchKey = "";  

      List<String> productCode = new ArrayList<String>();
      productCode.add("MWE");
      productCode.add("MPL");
      
      
      SearchRequest searchRequest = new SearchRequest();
      searchRequest.setProgram("priceless");
      searchRequest.setKeywords(searchKey);
      searchRequest.setProductCode(productCode);

      String response = apiClient.getSearchOffers(searchRequest);
      Assert.assertTrue(response.contains("<ResponseCode>200</ResponseCode>"));
      System.out.println(response);
    }
    
    
    @Test
    public void testSearchOffersByTagCategory() {
        
      String searchKey = "offer";  
      List<String> tagCategory = new ArrayList<String>();
      tagCategory.add("SHOP");
      
      SearchRequest searchRequest = new SearchRequest();
      searchRequest.setProgram("priceless");
      searchRequest.setKeywords(searchKey);
      searchRequest.setTagCategory(tagCategory);

      String response = apiClient.getSearchOffers(searchRequest);
      Assert.assertTrue(response.contains("<ResponseCode>200</ResponseCode>"));
      System.out.println(response);
    }
    
    @Test
    public void testSearchOffersByGeo() {
        
      List<Geo> sourceGeos = new ArrayList<Geo>();
      Geo geo = new Geo();
      geo.setCity(new GeoAttribute("newyork"));
      sourceGeos.add(geo);
      
      SearchRequest searchRequest = new SearchRequest();
      searchRequest.setProgram("priceless");
      searchRequest.setSourceGeos(sourceGeos);

      String response = apiClient.getSearchOffers(searchRequest);
      Assert.assertTrue(response.contains("<ResponseCode>200</ResponseCode>"));
      System.out.println(response);
    }
    
    @Test
    public void testSearchOffersByMerchant() {
        
      List<Geo> sourceGeos = new ArrayList<Geo>();
      Geo geo = new Geo();
      geo.setCity(new GeoAttribute("newyork"));
      sourceGeos.add(geo);
      
      
      SearchRequest searchRequest = new SearchRequest();
      searchRequest.setProgram("priceless");
      searchRequest.setSourceGeos(sourceGeos);
      searchRequest.setMerchantName("GILT");
      
      String response = apiClient.getSearchOffers(searchRequest);
      Assert.assertTrue(response.contains("<ResponseCode>200</ResponseCode>"));
      System.out.println(response);
    }
    
    @Test
    public void testNearBySearch() {
        
      List<Geo> sourceGeos = new ArrayList<Geo>();
      Geo geo = new Geo();
 
      geo.setLatitude(40.7127F);
      geo.setLongitude(74.0059F);
      sourceGeos.add(geo);
      
      SearchRequest searchRequest = new SearchRequest();
      searchRequest.setProgram("priceless");
      searchRequest.setSourceGeos(sourceGeos);
      searchRequest.setRange(50);
      
      OfferApi api = new OfferApi();
      
      List<Offer> response = api.searchOffers(searchRequest);
      Assert.assertNotNull(response);

    }
}
