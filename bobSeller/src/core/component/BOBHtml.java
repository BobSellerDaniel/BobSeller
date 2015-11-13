package core.component;

import java.util.List;

public class BOBHtml {
	
	private List<BOBHtmlElement> fields;
	private String idHTML;
	private BOBHtmlElement submit;
	private String title;
	private String description;
	private boolean exportData;
	private boolean importData;
	private boolean saveCloseBt;
	private boolean saveBt;
	private boolean closeBt;
	private List<BOBCRUD> crud;
	private boolean isList;
	private boolean isForm;
	private List<List<String>> fieldList;
	private List<BOBHtmlElement> theader;
	
	public String OuputHtml(){	
		return "<table>"
				+ "<tr>"
					+ "<td>"
						+ "hola"
					+ "<td>"
				+ "<tr>"
			 + "</table>";
	}
	
	
	public List<BOBHtmlElement> getFields() {return fields;}
	public void setFields(List<BOBHtmlElement> fields) {this.fields = fields;}
	
	public BOBHtmlElement getSubmit() {return submit;}
	public void setSubmit(BOBHtmlElement submit) {this.submit = submit;}
	
	public String getTitle() {return title;}
	public void setTitle(String title) {this.title = title;}
	
	public String getDescription() {return description;}
	public void setDescription(String description) {this.description = description;}
	
	public boolean isExportData() {return exportData;}
	public void setExportData(boolean exportData) {this.exportData = exportData;}
	
	public boolean isImportData() {return importData;}
	public void setImportData(boolean importData) {this.importData = importData;}
	
	public boolean isSaveCloseBt() {return saveCloseBt;}
	public void setSaveCloseBt(boolean saveCloseBt) {this.saveCloseBt = saveCloseBt;}
	
	public boolean isSaveBt() {return saveBt;}
	public void setSaveBt(boolean saveBt) {this.saveBt = saveBt;}
	
	public boolean isCloseBt() {return closeBt;}
	public void setCloseBt(boolean closeBt) {this.closeBt = closeBt;}
		
	public List<BOBCRUD> getCrud() {return crud;}
	public void setCrud(List<BOBCRUD> crud) {this.crud = crud;}
	
	public boolean getIsList() {return isList;}
	public void setIsList(boolean isList) {this.isList = isList;}
	
	public boolean getIsForm() {return isForm;}
	public void setIsForm(boolean isForm) {this.isForm = isForm;}
	
	public List<List<String>> getFieldList() {return fieldList;}
	public void setFieldList(List<List<String>> fieldList) {this.fieldList = fieldList;}
	
	public List<BOBHtmlElement> getTheader() {return theader;}
	public void setTheader(List<BOBHtmlElement> theader) {this.theader = theader;}
	
	@Override
	public String toString() {
		return "BOBHtml [fields=" + fields + ", submit=" + submit + ", title=" + title + ", description=" + description
				+ ", exportData=" + exportData + ", importData=" + importData + ", saveCloseBt=" + saveCloseBt
				+ ", saveBt=" + saveBt + ", closeBt=" + closeBt
				+ ", crud=" + crud + ", isList=" + isList + ", isForm=" + isForm + ", fieldList=" + fieldList
				+ ", theader=" + theader + "]";
	}


	public String getIdHTML() {
		return idHTML;
	}


	public void setIdHTML(String idHTML) {
		this.idHTML = idHTML;
	}

	
}
