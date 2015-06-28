package com.eop.api;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import javax.net.ssl.HttpsURLConnection;
import javax.xml.bind.JAXBException;

import com.eop.api.io.SearchRequest;
import com.eop.api.offerdetail.gen.GetOfferDetailsResponse;
import com.eop.api.sample.client.MCApiUtil;
import com.eop.api.search.gen.BrowseOffersResponse;
import com.eop.api.util.JaxbUtil;
import com.eop.api.util.PropertyUtil;

/**
 * Ravi K
 */
public class ApiClient {

    private boolean isProduction = PropertyUtil.getInstance().getBooleanProperty(PropertyUtil.API_PROD_ENABLE);
    String sandboxRequestBaseURL = PropertyUtil.getInstance().getProperty(PropertyUtil.API_SANDBOX_URL);
    String prodRequestBaseURL = PropertyUtil.getInstance().getProperty(PropertyUtil.API_PROD_URL);
    
    String prodClientId = PropertyUtil.getInstance().getProperty(PropertyUtil.API_PROD_CLIENT_ID);
    String sandboxClientId = PropertyUtil.getInstance().getProperty(PropertyUtil.API_SANDBOX_CLIENT_ID);
    
    MCApiUtil reader = new MCApiUtil();

    
    public String getRedemptionCodes(String offerId) {
        
        String offerDetailsURL = (isProduction ? prodRequestBaseURL : sandboxRequestBaseURL ) + "redemptioncode/" + offerId;
        StringBuffer responseBuffer = new StringBuffer();

        try {
            HttpsURLConnection createOpenAPIConnection = reader.createOpenAPIConnection(offerDetailsURL, null, isProduction? prodClientId : sandboxClientId);

            int responseCode = createOpenAPIConnection.getResponseCode();
            System.out.println("\nSending 'GET' request to URL : " + offerDetailsURL);
            System.out.println("Response Code : " + responseCode);

            BufferedReader in = new BufferedReader(new InputStreamReader(createOpenAPIConnection.getInputStream()));
            String inputLine;

            while ((inputLine = in.readLine()) != null) {
                responseBuffer.append(inputLine);
            }
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
            responseBuffer.append(e.getMessage());
        }

        return responseBuffer.toString();
    }
    
    
    public String getRecentOffers(Integer hours) {
        
        String offerDetailsURL = (isProduction ? prodRequestBaseURL : sandboxRequestBaseURL ) + "recentofferids/" + hours;
        StringBuffer responseBuffer = new StringBuffer();

        try {
            HttpsURLConnection createOpenAPIConnection = reader.createOpenAPIConnection(offerDetailsURL, null, isProduction? prodClientId : sandboxClientId);

            int responseCode = createOpenAPIConnection.getResponseCode();
            System.out.println("\nSending 'GET' request to URL : " + offerDetailsURL);
            System.out.println("Response Code : " + responseCode);

            BufferedReader in = new BufferedReader(new InputStreamReader(createOpenAPIConnection.getInputStream()));
            String inputLine;

            while ((inputLine = in.readLine()) != null) {
                responseBuffer.append(inputLine);
            }
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
            responseBuffer.append(e.getMessage());
        }

        return responseBuffer.toString();
    }
    

    public String getOfferInventory(String offerId) {
        
        String offerDetailsURL = (isProduction ? prodRequestBaseURL : sandboxRequestBaseURL ) + "inventory/" + offerId ;
        StringBuffer responseBuffer = new StringBuffer();

        try {
            HttpsURLConnection createOpenAPIConnection = reader.createOpenAPIConnection(offerDetailsURL, null, isProduction? prodClientId : sandboxClientId);

            int responseCode = createOpenAPIConnection.getResponseCode();
            System.out.println("\nSending 'GET' request to URL : " + offerDetailsURL);
            System.out.println("Response Code : " + responseCode);

            BufferedReader in = new BufferedReader(new InputStreamReader(createOpenAPIConnection.getInputStream()));
            String inputLine;

            while ((inputLine = in.readLine()) != null) {
                responseBuffer.append(inputLine);
            }
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
            responseBuffer.append(e.getMessage());
        }

        return responseBuffer.toString();
    }

    
    public String getOfferDetails(String offerId) {
        
        String offerDetailsURL = (isProduction ? prodRequestBaseURL : sandboxRequestBaseURL ) + "detail/" + offerId ;
        StringBuffer responseBuffer = new StringBuffer();

        try {
            HttpsURLConnection createOpenAPIConnection = reader.createOpenAPIConnection(offerDetailsURL, null, isProduction? prodClientId : sandboxClientId);

            int responseCode = createOpenAPIConnection.getResponseCode();
            System.out.println("\nSending 'GET' request to URL : " + offerDetailsURL);
            System.out.println("Response Code : " + responseCode);

            BufferedReader in = new BufferedReader(new InputStreamReader(createOpenAPIConnection.getInputStream()));
            String inputLine;

            while ((inputLine = in.readLine()) != null) {
                responseBuffer.append(inputLine);
            }
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
            responseBuffer.append(e.getMessage());
        }

        return responseBuffer.toString();
    }

    public GetOfferDetailsResponse getOfferDetail(String offerId) {
        String offerDetail = getOfferDetails(offerId);
        GetOfferDetailsResponse convertToJaxb = null;
        try {
            convertToJaxb = JaxbUtil.convertToJaxb(GetOfferDetailsResponse.class, offerDetail);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return convertToJaxb;
    }

    public String getSearchOffers(SearchRequest searchRequest) {

        String searchRequestURL = (isProduction ? prodRequestBaseURL : sandboxRequestBaseURL ) + "search";
        StringBuffer response = new StringBuffer();

        String body = getSearchOfferPayload(searchRequest);

        System.out.println("Message Body : " + body);
        try {
            HttpsURLConnection createOpenAPIConnection = reader.createOpenAPIConnection(searchRequestURL, body, isProduction? prodClientId : sandboxClientId);

            int responseCode = createOpenAPIConnection.getResponseCode();
            System.out.println("\nSending request to URL : " + searchRequestURL);
            System.out.println("Response Code : " + responseCode);

            BufferedReader in = new BufferedReader(new InputStreamReader(createOpenAPIConnection.getInputStream()));
            String inputLine;

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return response.toString();
    }

    public BrowseOffersResponse searchOffer(SearchRequest searchRequest) {
        String searchResults = getSearchOffers(searchRequest);
        BrowseOffersResponse convertToJaxb = null;
        try {
            convertToJaxb = JaxbUtil.convertToJaxb(BrowseOffersResponse.class, searchResults);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return convertToJaxb;
    }

    private static String getSearchOfferPayload(SearchRequest searchRequest) {

        String requestXML = null;
        try {
            requestXML = JaxbUtil.convertToXmlString(SearchRequest.class, searchRequest);
        } catch (JAXBException e) {
            e.printStackTrace();
            requestXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" + "<OfferSearchCriteria>" + "     <Platform>priceless</Platform>" + "</OfferSearchCriteria>";
        }

        return requestXML;
    }


    public String updateInventory(String offerId, int redeemedQuantity) {
 
        
        String offerDetailsURL = (isProduction ? prodRequestBaseURL : sandboxRequestBaseURL ) + "inventory/" + offerId +"/"+redeemedQuantity ;
        StringBuffer responseBuffer = new StringBuffer();

        try {
            HttpsURLConnection createOpenAPIConnection = reader.createOpenAPIConnection(offerDetailsURL, null, isProduction? prodClientId : sandboxClientId);

            int responseCode = createOpenAPIConnection.getResponseCode();
            System.out.println("\nSending 'GET' request to URL : " + offerDetailsURL);
            System.out.println("Response Code : " + responseCode);

            BufferedReader in = new BufferedReader(new InputStreamReader(createOpenAPIConnection.getInputStream()));
            String inputLine;

            while ((inputLine = in.readLine()) != null) {
                responseBuffer.append(inputLine);
            }
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
            responseBuffer.append(e.getMessage());
        }

        return responseBuffer.toString();
    }

}
