package pif.modele;

import com.google.gson.annotations.SerializedName;

public class IrrelevantWord {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@SerializedName("_id")
	private String id;
	
	@SerializedName("_rev")
	private String rev;
	
	public IrrelevantWord() {
	}

	public IrrelevantWord(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRev() {
		return rev;
	}

	public void setRev(String rev) {
		this.rev = rev;
	}
	
}
