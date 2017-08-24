package dataobject;

public class Brand {
	private int brandId;
	private String brandName;
	private String brandDescription;
	
	public Brand(){};
	
	public Brand(int brandId, String brandName, String brandDescription) {
		super();
		this.brandId = brandId;
		this.brandName = brandName;
		this.brandDescription = brandDescription;
	}
	public String getBrandDescription() {
		return brandDescription;
	}
	public void setBrandDescription(String brandDescription) {
		this.brandDescription = brandDescription;
	}
	public int getBrandId() {
		return brandId;
	}
	public void setBrandId(int string) {
		this.brandId = string;
	}
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	@Override
	public String toString() {
		return brandName + brandDescription ;
	}

	
	
}
