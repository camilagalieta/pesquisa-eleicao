package util;

public class ComboBoxCandidatoItem {

	private String value;
	private Integer key;

	public ComboBoxCandidatoItem(Integer key, String value) {
		this.key = key;
		this.value = value;
	}

	public String toString() {
        return this.value;
    }
    
    public Integer getKey() {
    	return this.key;
    }
    
    public String getValue() {
    	return this.value;
    }
}
