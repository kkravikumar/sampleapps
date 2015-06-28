/**
 * 
 */
package com.eop.api.io;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Ravi K
 */
@XmlRootElement(name = "OfferSearchCriteria")
public class SearchRequest {

    private String keywords;
    private String language;
    private Integer itemsPerPage;
    private List<String> category;
    private String merchantName;
    List<String> tag;
    List<String> tagCategory;
    List<String> tagTier;
    private List<Geo> sourceGeos;
    private String targetFis;
    private List<String> productCode;
    private List<Geo> targetGeos;
    private String program;
    private Integer range;

    @XmlElement(name = "Program")
    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    /**
     * @return the language
     */
    @XmlElement(name = "Language")
    public String getLanguage() {
        return language;
    }

    /**
     * @param language the language to set
     */
    public void setLanguage(String language) {
        this.language = language;
    }

    /**
     * @return the keywords
     */
    @XmlElement(name = "Keywords")
    public String getKeywords() {
        return keywords;
    }

    /**
     * @param keywords the keywords to set
     */
    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    /**
     * @return the itemsPerPage
     */
    public Integer getItemsPerPage() {
        return itemsPerPage;
    }

    /**
     * @param itemsPerPage the itemsPerPage to set
     */
    public void setItemsPerPage(Integer itemsPerPage) {
        this.itemsPerPage = itemsPerPage;
    }

    /**
     * @return the category
     */
    @XmlElement(name = "Category")
    public List<String> getCategory() {
        return category;
    }

    /**
     * @param category the category to set
     */
    public void setCategory(List<String> category) {
        this.category = category;
    }

    /**
     * @return the merchantName
     */
    @XmlElement(name = "MerchantName")
    public String getMerchantName() {
        return merchantName;
    }

    /**
     * @param merchantName the merchantName to set
     */
    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    /**
     * @return the tag
     */
    @XmlElement(name = "Tag")
    public List<String> getTag() {
        return tag;
    }

    /**
     * @param tag the tag to set
     */
    public void setTag(List<String> tag) {
        this.tag = tag;
    }

    /**
     * @return the tagCategory
     */
    @XmlElement(name = "TagCategory")
    public List<String> getTagCategory() {
        return tagCategory;
    }

    /**
     * @param tagCategory the tagCategory to set
     */
    public void setTagCategory(List<String> tagCategory) {
        this.tagCategory = tagCategory;
    }

    /**
     * @return the sourceGeos
     */
    @XmlElementWrapper(name = "SourceGeos")
    @XmlElement(name = "Geo")
    public List<Geo> getSourceGeos() {
        return sourceGeos;
    }

    /**
     * @param sourceGeos the sourceGeos to set
     */
    public void setSourceGeos(List<Geo> sourceGeos) {
        this.sourceGeos = sourceGeos;
    }

    /**
     * @return the tagTier
     */
    @XmlElement(name = "TagTier")
    public List<String> getTagTier() {
        return tagTier;
    }

    /**
     * @param tagTier the tagTier to set
     */
    public void setTagTier(List<String> tagTier) {
        this.tagTier = tagTier;
    }

    /**
     * @return the targetFis
     */
    @XmlElement(name = "TargetFis")
    public String getTargetFis() {
        return targetFis;
    }

    /**
     * @param targetFis the targetFis to set
     */
    public void setTargetFis(String targetFis) {
        this.targetFis = targetFis;
    }

    /**
     * @return the productCode
     */
    @XmlElement(name = "ProductName")
    public List<String> getProductCode() {
        return productCode;
    }

    /**
     * @param productCode the productCode to set
     */
    public void setProductCode(List<String> productCode) {
        this.productCode = productCode;
    }

    @XmlElementWrapper(name = "TargetGeos")
    @XmlElement(name = "Geo")
    public List<Geo> getTargetGeos() {
        return targetGeos;
    }

    public void setTargetGeos(List<Geo> targetGeos) {
        this.targetGeos = targetGeos;
    }
    
    @XmlElement(name = "Range")
	public Integer getRange() {
		return range;
	}

	public void setRange(Integer range) {
		this.range = range;
	}

}
