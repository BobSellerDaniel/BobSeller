package core.component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
	private Set<BOBCRUD> crud;

	private List fieldList;
	private List<BOBHtmlElement> theader;
	private List<BOBHtmlElement> tabs;
	private HttpServletRequest request;
	
	public String OuputHtml(){
		
		String htmlOuput ="<div class='WrapperTablaList'>";
		
		htmlOuput += "<div class='TituloTop'><div class='tabs'>";
		
		String BackgroundColorTab = "#F8F8F8"; 
		String requestVtab = "";
		String nameTabs = "true";
		String vTabId = "";
		if(tabs != null){
			for(BOBHtmlElement tab: tabs){
				htmlOuput += "<div class='tabMenus'>" 
					+ "<a href='"+request.getRequestURL()+"?vtab="+tab.getId()+"'><div class='tabTitulo' style='background-color:"+tab.getBackgroundColor()+";padding: 4px;' title='"+tab.getLabel()+"' >"
							+ "<img width='100%' src='"+tab.getRecursoUrl()+"' >"
					+ "</div></a>"
					+ "</div>";
				if(tab.getSeleted()){
					nameTabs = tab.getId();
					BackgroundColorTab = "background-color:"+tab.getBackgroundColor()+"; opacity: 0.2;";
					requestVtab = "<input type='hidden' name='vtab' value='"+tab.getId()+"'>";
					vTabId = tab.getId();
				}
			}
		}
		
		htmlOuput += "</div>";
		htmlOuput += "<div class='LabelTitulo'>"+title+"</div>";
		htmlOuput += "<div class='TituloTabla' style='"+BackgroundColorTab+"'>&nbsp;</div></div>";
		
		htmlOuput += "<form id='"+idHTML+"' method='post' action='"+request.getRequestURL()+"'>";
		htmlOuput += "<INPUT type='hidden' name='vfilterID' value='"+request.getParameter("vfilterID")+"' id='vfilterID'/>";
		
		htmlOuput += requestVtab;
		
		int NunPagin =  0;
		int PaginaActual =  0;
		int PaginaSig =  0;
		
		if(request.getParameter("pag") != null){
			
		}else{
			NunPagin = (int)(nunRegistro/10) > 1 ?nunRegistro/10:1; 
			PaginaActual = (int) ((request.getParameter("pagAct") != null)? Integer.parseInt(request.getParameter("pagAct")):NunPagin);
			PaginaSig = (PaginaActual < NunPagin)?PaginaActual+1:NunPagin;
		}
		
		
		String paginador = "<div class='paginador'><div style='position: relative;float: left; padding: 10px;'><table><tr>";
		paginador += "<td>Pagina: "+PaginaActual+" / "+NunPagin+" "
				+ "<input type='image' src='../img/list-next.gif' onclick='enviarForm(\""+idHTML+"\",\"pagAct\",1)'>"
				+ "&nbsp;&nbsp;<input type='image' src='../img/list-next2.gif' onclick='enviarForm(\""+idHTML+"\",\"ultPag\",1)'>"
				+ "&nbsp;|&nbsp;Mostrar "
				+ "<select name='order_pagination' onchange='submit()'>";
		paginador += (NunPagin >= 20)?"<option value='20' selected='selected'>20</option>":"<option value='1' selected='selected'>	1</option>";
		paginador += (NunPagin >= 50)?"<option value='50'>50</option>":"";
		paginador += (NunPagin >= 100)?"<option value='100'>100</option>":"";
		paginador += (NunPagin >= 300)?"<option value='300'>300</option>":""
				+ "</select>"
				+ "&nbsp; / "+nunRegistro+" resultado(s)&nbsp;</td>";
		
		paginador += "<input type='hidden' id='pagAct' name='pagAct' value='"+PaginaSig+"'> "
				  +  "<input type='hidden' id='ultPag'name='ultPag' value='"+NunPagin+"'>"
				  +  "</tr></table></div><div style='position: relative; float: right; padding: 10px;'>"
				  + "<a href='"+request.getRequestURL()+"?vCrear="+nameTabs+"' class='button'>+ Crear</a>"
				  + "&nbsp;<input type='submit' onclick='document.getElementById(\"vfilterID\").value=true;' name='vfilter' value='Filtrar'  class='button'>"
				  + "&nbsp;<input type='submit' onclick='document.getElementById(\"vfilterID\").value=false;' name='vfilter' value='Borrar Filtro'  class='button'>"
				  + "</div></div>";
		
		htmlOuput += paginador;
		
		htmlOuput += "<div id='tabla-"+idHTML+"' class='BobTablaList'><table ><tr>";
				
		int contCol = 0;
		String primary = "";
		for(BOBHtmlElement row: theader){
			contCol++;
			String Id = (row.getId() != "") ? row.getId() : "";
			String cssClass = (row.getCssClass() != "") ? row.getCssClass() : "";
			htmlOuput += "<th class='col-"+contCol+" "+cssClass+"' style='width:"+row.getWidth()+"' id='th-"+Id+"'>"+row.getLabel()+"</th>";
			if (row.getIsPrimaryDB()){
				primary = row.getId();
			}
		}
		
		htmlOuput += "<th style='width:10%' id='AccTable' class='centrar' colspan='"+crud.size()+"'>Acciones</th>";		
		htmlOuput += "</tr><tr>";
		
		contCol = 0;
		for(BOBHtmlElement row: theader){
			contCol++;
			String Id = (row.getId() != "") ? row.getId() : "";
			htmlOuput += "<th class='col-"+contCol+"' style='width:"+row.getWidth()+"'>"
					+ "<input type='text' id='input-"+Id+"' name='"+Id+"' title='Busca por: "+row.getLabel()+"' style='width:98%'></th>";
		}
		
		String crudStr = "";
		if (crud.contains(BOBCRUD.retrieve)){
			htmlOuput += "<th style='width:10%' class='centrar'>--</th>";	
			crudStr += "<td class='centrar'><a href='"+request.getRequestURL()+"?vIDRow=;ID;&vAction=view&vtab="+vTabId+"'><img src='../img/small/search.png' class='tableImg' /></a></td>";
		}
		if (crud.contains(BOBCRUD.update)){
			htmlOuput += "<th style='width:10%' class='centrar'>--</th>";	
			crudStr += "<td class='centrar'><a href='"+request.getRequestURL()+"?vIDRow=;ID;&vAction=edit&vtab="+vTabId+"'><img src='../img/small/compose-4.png' class='tableImg' /></a></td>";
		}
		if (crud.contains(BOBCRUD.delete)){
			htmlOuput += "<th style='width:10%' class='centrar'>--</th>";	
			crudStr += "<td class='centrar'><a href='"+request.getRequestURL()+"?vIDRow=;ID;&vAction=delete&vtab="+vTabId+"'><img src='../img/small/bin-3.png' class='tableImg' /></a></td>";
		}
		htmlOuput += "</tr></theader><tbody>";
		
		int contEstilo = 1;
		
		for(Object row: fieldList){
			
			if(contEstilo == 1){
				contEstilo = 0;
				htmlOuput += "<tr class='trList' style='background-color: gainsboro;'>"; 
			}else{
				contEstilo = 1;
				htmlOuput += "<tr class='trList'>";
			}
			
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
						htmlOuput += "<td class='col-"+contCol+" "+rowTh.getCssClass()+" rollover' style='width:"+rowTh.getWidth()+"'>"+tmpObjeId.get(JSONObject.getNames(tmpObjeId)[0])+""
								  + "<div style='display:none;'>";
						htmlOuput += "<table>";
						htmlOuput += tmpObje.getJSONArray(JSONObject.getNames(tmpObje)[0]).toString().replace("[", "").replace("]", "").replace(",", "").replace("{\"", "<tr><td>").replace("\":", "</td><td>").replace("}","</td></tr>").replace("\"", "");
						htmlOuput += "</table></div></td>";
					}
					
					else {
						htmlOuput += "<td class='col-"+contCol+" "+rowTh.getCssClass()+"' style='width:"+rowTh.getWidth()+"'>"+values.get(rowTh.getId())+"</td>";
					}
				}
				htmlOuput += crudStr.replaceAll(";ID;", values.get(primary).toString());				
				
			} catch (JSONException e) {
				e.printStackTrace();
			}
			
			htmlOuput += "</tr>";
		}
		
		htmlOuput += "</table></div>"+paginador+ "</form></div>";
		return htmlOuput;
	}
	
	public String OuputHtmlForm(){

		if (fields == null){
			return "EL elemento no cuenta con información para mostrar";			
		}
		
		String htmlOuput ="	<div class='WrapperFormViewEdit'>";
		htmlOuput += "			<div class='FormViewEditTitle'>";
		htmlOuput += "				Algun titulo";
		htmlOuput += "			</div>";
		htmlOuput += "			<div class='FormViewEditDesc'>";
		htmlOuput += "				Alguna descripción ..... Alguna descripción ..... Alguna descripción ..... Alguna descripción ..... Alguna descripción ..... Alguna descripción ..... Alguna descripción ..... Alguna descripción ..... Alguna descripción ..... Alguna descripción ..... Alguna descripción ..... Alguna descripción ..... Alguna descripción ..... Alguna descripción ..... Alguna descripción ..... Alguna descripción .....  Alguna descripción ..... Alguna descripción ..... Alguna descripción ..... Alguna descripción ..... Alguna descripción ..... Alguna descripción ..... Alguna descripción ..... Alguna descripción ..... ";
		htmlOuput += "			</div>";
		htmlOuput += "			<div class='FormViewEdit'>";
		htmlOuput += "				<ul>";
		
		for (BOBHtmlElement field : fields){
			BOBHtmlTag tag = field.getTag();
			String classs = field.getCssClass()==null?"":field.getCssClass();
			String id = field.getId()==null?"":field.getId();
			String label = field.getLabel()==null?"":field.getLabel();
			String name = field.getName()==null?"":field.getName();
			String onclick = field.getOnclick()==null?"":field.getOnclick();
			String onRollOver = field.getOnrollover()==null?"":field.getOnrollover();
			String required = field.getRequired()==null?"":field.getRequired();
			String value = field.getValue()==null?"":field.getValue();
			String width = field.getWidth()==null?"":field.getWidth();
			String format = field.getFormat()==null?BOBFormat.string.name():field.getFormat().name();
			boolean drawIf = true; // TODO IMPLEMENT
			String backgroundColor = field.getBackgroundColor()==null?"":field.getBackgroundColor();
			String cols = field.getCol()==null?"":field.getCol();
			String content = field.getContent()==null?"":field.getContent();
			String rows = field.getRows()==null?"":field.getRows();
			//String value = field.()==null?"":field.getValue();
			

			htmlOuput += "				<li>";
			htmlOuput += "				<span>"+label+":</span>";
			if(tag.ordinal() == BOBHtmlTag.input.ordinal()){
				
				htmlOuput += "				<input value='agregar un input'/>";				
			}else if (tag.ordinal() == BOBHtmlTag.select.ordinal()){
				htmlOuput += "				<select>";								
				htmlOuput += "					<option>agregar un select</option>";								
				htmlOuput += "				</select>";								
			}else if (tag.ordinal() == BOBHtmlTag.textarea.ordinal()){
				htmlOuput += "				<textarea rows='"+field.getRows()+"' cols='"+field.getCol()+"'>agregar un textarea";				
				htmlOuput += "				</textarea>";				
			}
			else{
				htmlOuput += "				el tipo de elemento solicitado no esta diponible para formulario :(";				
			}
			htmlOuput += "				</li>";
		}
		htmlOuput += "				</ul>";
		htmlOuput += "				<div class='FormViewEditButtons'>";
		// determinar el botón save 
		if (saveBt && (crud.contains(BOBCRUD.update) || crud.contains(BOBCRUD.create))){
			htmlOuput += "				<div>";					
			htmlOuput += "					<input type='button' value='Salvar'/>";					
			htmlOuput += "				</div>";					
		}
		// determinar el botón Save and close 
		if (saveCloseBt && (crud.contains(BOBCRUD.update) || crud.contains(BOBCRUD.create))){
			htmlOuput += "				<div>";					
			htmlOuput += "					<input type='button' value='Salvar y salir'/>";					
			htmlOuput += "				</div>";					
		}
		// determinar el botón close 
		if (closeBt){
			htmlOuput += "				<div>";					
			htmlOuput += "					<input type='button' value='salir'/>";					
			htmlOuput += "				</div>";					
		}
		htmlOuput += "				</div>";		
		htmlOuput += "			</div>";
		htmlOuput += "		</div>";
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
		
	public Set<BOBCRUD> getCrud() {return crud;}
	public void setCrud(Set<BOBCRUD> crud) {this.crud = crud;}
	
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
	
	public List<BOBHtmlElement> getTabs() {return tabs;}
	public void setTabs(List<BOBHtmlElement> tabs) {this.tabs = tabs;}

	@Override
	public String toString() {
		return "BOBHtml [fields=" + fields + ", idHTML=" + idHTML + ", submit=" + submit + ", title=" + title
				+ ", description=" + description + ", exportData=" + exportData + ", showPaginator=" + showPaginator
				+ ", nunRegistro=" + nunRegistro + ", importData=" + importData + ", saveCloseBt=" + saveCloseBt
				+ ", saveBt=" + saveBt + ", closeBt=" + closeBt + ", crud=" + crud + ", fieldList=" + fieldList + ", theader=" + theader + ", tabs=" + tabs + ", request="
				+ request + "]";
	}

}
