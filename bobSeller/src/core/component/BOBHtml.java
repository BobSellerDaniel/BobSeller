package core.component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class BOBHtml {
	
	private List<BOBHtmlElement> fields;
	private String idHTML;
	private BOBHtmlElement submit;
	private String title;
	private String description;
	private boolean exportData;
	private boolean showPaginator;
	private int nunRegistro;
	private boolean importData;
	private boolean saveCloseBt;
	private boolean saveBt;
	private boolean closeBt;
	private List<BOBCRUD> crud;
	private boolean isList;
	private boolean isForm;
	private List fieldList;
	private List<BOBHtmlElement> theader;
	private HttpServletRequest request;
	
	public String OuputHtml(){
		
		String htmlOuput ="<div class='WrapperTablaList'><form id='"+idHTML+"' method='post' action='"+request.getRequestURL()+"'>";
		
		int NunPagin =  0;
		int PaginaActual =  0;
		int PaginaSig =  0;
		
		if(request.getParameter("pag") != null){
			
		}else{
			NunPagin = (int)(nunRegistro/10) > 1 ?nunRegistro/10:1; 
			PaginaActual = (int) ((request.getParameter("pagAct") != null)? Integer.parseInt(request.getParameter("pagAct")):NunPagin);
			PaginaSig = (PaginaActual < NunPagin)?PaginaActual+1:NunPagin;	
			//System.out.println("NunPagin: "+NunPagin+" -- PaginaActual: "+PaginaActual+" -- PaginaSig: "+PaginaSig);
		}
		
		htmlOuput += "<div><div style='position: relative;float: left; padding: 10px;'><table><tr>";
		htmlOuput += "<td>Pagina: "+PaginaActual+" / "+NunPagin+" "
				+ "<input type='image' src='../img/list-next.gif' onclick='enviarForm(\""+idHTML+"\",\"pagAct\",1)'>"
				+ "&nbsp;&nbsp;<input type='image' src='../img/list-next2.gif' onclick='enviarForm(\""+idHTML+"\",\"ultPag\",1)'>"
				+ "&nbsp;|&nbsp;Mostrar "
				+ "<select name='order_pagination' onchange='submit()'>";
		htmlOuput += (NunPagin >= 20)?"<option value='20' selected='selected'>20</option>":"<option value='1' selected='selected'>	1</option>";
		htmlOuput += (NunPagin >= 50)?"<option value='50'>50</option>":"";
		htmlOuput += (NunPagin >= 100)?"<option value='100'>100</option>":"";
		htmlOuput += (NunPagin >= 300)?"<option value='300'>300</option>":""
				+ "</select>"
				+ "&nbsp; / "+nunRegistro+" resultado(s)&nbsp;</td>";
		
		htmlOuput += "<input type='hidden' id='pagAct' name='pagAct' value='"+PaginaSig+"'> "
				  +  "<input type='hidden' id='ultPag'name='ultPag' value='"+NunPagin+"'>"
				  +  "</tr></table></div><div style='position: relative; float: right; padding: 10px;'>sdfsdf</div></div>";
		htmlOuput += "<div id='tabla-"+idHTML+"' class='BobTablaList'><table ><tr>";
				
		for(BOBHtmlElement row: theader){
			String Id = (row.getId() != "") ? row.getId() : "";
			String cssClass = (row.getCssClasss() != "") ? row.getCssClasss() : "";
			htmlOuput += "<th id='th-"+Id+"' class='order "+cssClass+"'>"+row.getLabel()+"</th>";
		}
		
		htmlOuput += "</tr><tr>";
		
		int contCol = 1;
		for(BOBHtmlElement row: theader){
			contCol++;
			String Id = (row.getId() != "") ? row.getId() : "";
			htmlOuput += "<th class='col-"+contCol+"'><input type='text' id='input-"+Id+"' name='"+Id+"' title='Busca por: "+row.getLabel()+"'></th>";
		}
		
		htmlOuput += "</tr></theader><tbody>";
	
		for(Object row: fieldList){
			htmlOuput += "<tr>";
			JSONObject obj;
			try {
				
				obj = new JSONObject(row.toString());
				JSONArray array = obj.getJSONArray(row.getClass().getSimpleName());
				Map<String,Object> values = new HashMap<String, Object>();
				
				for(int i = 0 ; i < array.length() ; i++){
					values.put(JSONObject.getNames(array.getJSONObject(i))[0], array.getJSONObject(i).get(JSONObject.getNames(array.getJSONObject(i))[0]));
				}
				
				contCol = 0;
				for(BOBHtmlElement rowTh: theader){
					contCol++;
					if(values.get(rowTh.getId()) instanceof JSONObject){
						JSONObject tmpObje = (JSONObject) values.get(rowTh.getId());
						JSONObject tmpObjeId = (JSONObject) tmpObje.getJSONArray(JSONObject.getNames(tmpObje)[0]).get(0);
						htmlOuput += "<td class='col-"+contCol+"'>"+tmpObjeId.get(JSONObject.getNames(tmpObjeId)[0])+"<div style='display:none;'>";
						htmlOuput += "<table>";
						htmlOuput	+= tmpObje.getJSONArray(JSONObject.getNames(tmpObje)[0]).toString().replace("[", "").replace("]", "").replace(",", "").replace("{\"", "<tr><td>").replace("\":", "</td><td>").replace("}","</td></tr>").replace("\"", "");
						htmlOuput	+= "</table></div></td>";
					}
					else {
						htmlOuput += "<td class='col-"+contCol+"'>"+values.get(rowTh.getId())+"</td>";
					}
				}
				
			} catch (JSONException e) {
				e.printStackTrace();
			}
			
			htmlOuput += "</tr>";
		}
		
		htmlOuput += "</table></div></form></div>";
		return htmlOuput;
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
	
	public List getFieldList() {return fieldList;}
	public void setFieldList(List fieldList) {this.fieldList = fieldList;}
	
	public List<BOBHtmlElement> getTheader() {return theader;}
	public void setTheader(List<BOBHtmlElement> theader) {this.theader = theader;}

	public String getIdHTML() {return idHTML;}
	public void setIdHTML(String idHTML) {this.idHTML = idHTML;}

	public boolean isShowPaginator() {return showPaginator;}
	public void setShowPaginator(boolean showPaginator) {this.showPaginator = showPaginator;}

	public int getNunRegistro() {return nunRegistro;}
	public void setNunRegistro(int nunRegistro) {this.nunRegistro = nunRegistro;}

	public void setRequest(HttpServletRequest request) {this.request = request;}
	public HttpServletRequest getRequest() {return this.request;}
	
	@Override
	public String toString() {
		return "BOBHtml [fields=" + fields + ", submit=" + submit + ", title=" + title + ", description=" + description
				+ ", exportData=" + exportData + ", importData=" + importData + ", saveCloseBt=" + saveCloseBt
				+ ", saveBt=" + saveBt + ", closeBt=" + closeBt
				+ ", crud=" + crud + ", isList=" + isList + ", isForm=" + isForm + ", fieldList=" + fieldList
				+ ", theader=" + theader + "]";
	}
	
}
