package core.component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Entity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


/** Modelado de un elemento HTML:  la presente clase se transfiere a la vista y tiene como finalidad describir todos los 
 * atributos de un Tag Html por ejemplo un <input>.
 * @author daniel */
@Entity
public class BOBHtmlElement {

		private BOBHtmlTag tag;
		private BOBHtmlInputType type;
		private String id;
		private String name;
		private String value;
		private String cssClass;
		private String backgroundColor;
		private String width;
		private boolean required;
		private String label;
		private String rows;
		private String col;
		private String content;
		private String href;
		private String recursoUrl;
		private String onclick;
		private String onrollover;
		private boolean isprimaryBD;
		private boolean seleted;
		private BOBFormat format;
		private List children;
		private BOBHtmlElement wraper;
		private String title;
		
		public BOBHtmlElement(){}
		
		public BOBHtmlElement(BOBHtmlTag tag, BOBHtmlInputType type, String id, String name, String value, String cssClass, String backgroundColor,
				String width, boolean required, String label, String rows, String col, String content, String href, String recursoUrl,
				String onclick, String onrollover, boolean isprimaryBD, boolean seleted, BOBFormat format, List children,
				BOBHtmlElement wraper, String title) {
			super();
			this.tag = tag;
			this.type = type;
			this.id = id;
			this.name = name;
			this.value = value;
			this.cssClass = cssClass;
			this.backgroundColor = backgroundColor;
			this.width = width;
			this.required = required;
			this.label = label;
			this.rows = rows;
			this.col = col;
			this.content = content;
			this.href = href;
			this.recursoUrl = recursoUrl;
			this.onclick = onclick;
			this.onrollover = onrollover;
			this.isprimaryBD = isprimaryBD;
			this.seleted = seleted;
			this.format = format;
			this.children = children;
			this.wraper = wraper;
			this.title = title;
		}

		/**
		 * bla bla bla 
		 * @param label obligatorio required
		 * @param isprimaryBD obligatorio required
		 * @param id opcional optional
		 * @param cssClass opcional optional
		 * @param drawIf opcional optional true 
		 * @return un elemento de tipo TH o cabecera de una tabla HTML
		 */
		public static BOBHtmlElement getTh(String label, boolean isprimaryBD, String id, String cssClass, String widths) {
			BOBHtmlElement th = new BOBHtmlElement(BOBHtmlTag.th, null, id, null, null, cssClass, null, widths,
					false, label, null, null, null, null, null, null, null, isprimaryBD, false, null, null, null, null);
			return th;
		}
		 
		public static BOBHtmlElement getTab(String label, String id, String cssClass, String recursoUrl, String background, boolean seleted){
			BOBHtmlElement tab = new BOBHtmlElement(BOBHtmlTag.tab, null, id, null, null, cssClass, background,
					null,false, label, null, null, null, null, recursoUrl,
					null, null, false, seleted,null, null,null,null);
			return tab;
		} 
		
		public static BOBHtmlElement getInput(String label, String name, String title, String id, BOBHtmlInputType type, boolean required, String cssClass, String width){
			BOBHtmlElement input = new BOBHtmlElement(BOBHtmlTag.input, type, id, name, null, cssClass, null,
					width, required, label, null, null, null, null, null,
					null, null, false, false, null,null,
					null, title);				
			return input;
		}
		
		public static BOBHtmlElement getSelect(String label, String name, String title, String id, BOBHtmlTag tag, boolean required, String cssClass, String width, List children, String childrenId, String childrenTitle, String childrenIdSeletc){
						
			BOBHtmlElement select = new BOBHtmlElement(tag, null, id, name, null, cssClass, null,
			width, required, label, null, null, null, null, null,
			null, null, false, false, null, new ArrayList(),
			null, title);
			
			for(Object row: children){
				try { 
					
					JSONObject obj = new JSONObject(row.toString());
					JSONArray array = obj.getJSONArray(row.getClass().getSimpleName());
					Map<String,Object> values = new HashMap<String, Object>();
					
					for(int i = 0 ; i < array.length() ; i++){
						values.put(JSONObject.getNames(array.getJSONObject(i))[0], 
								array.getJSONObject(i).get(JSONObject.getNames(array.getJSONObject(i))[0]));
					}
										
					BOBHtmlElement selectOption = new BOBHtmlElement();
					selectOption.setTag(BOBHtmlTag.options);
					selectOption.setId(id+"-"+values.get(childrenId));
					selectOption.setValue(values.get(childrenId).toString());
					System.out.println("2");
					selectOption.setContent(values.get(childrenTitle).toString());
					
					if(values.get(childrenId) != null && childrenIdSeletc != null && 0 == values.get(childrenId).toString().compareTo(childrenIdSeletc)){
						selectOption.setSeleted(true);
					}else{
						selectOption.setSeleted(false);
					}
					System.out.println("3");
					select.getChildren().add(selectOption);
					
				} catch (Exception e) { System.out.println("Execpcion error "+e);}
			}
						
			return select;
		}

		
		public boolean drawIf(){return true;}
		
		public BOBHtmlTag getTag() {return tag;}
		public void setTag(BOBHtmlTag tag) {this.tag = tag;}
		
		public BOBHtmlInputType getType() {return type;}
		public void setType(BOBHtmlInputType type) {this.type = type;}
		
		public String getId() {return id;}
		public void setId(String id) {this.id = id;}
		
		public String getName() {return name;}
		public void setName(String name) {this.name = name;}
		
		public String getValue() {return value;}
		public void setValue(String value) {this.value = value;}
		
		public boolean getRequired() {return required;}
		public void setRequired(boolean required) {this.required = required;}
		
		public String getLabel() {return label;}
		public void setLabel(String label) {this.label = label;}
		
		public String getRows() {return rows;}
		public void setRows(String rows) {this.rows = rows;}
		
		public String getCol() {return col;}
		public void setCol(String col) {this.col = col;}
		
		public String getContent() {return content;}
		public void setContent(String content) {this.content = content;}
		
		public String getHref() {return href;}
		public void setHref(String href) {this.href = href;}
		
		public String getOnclick() {return onclick;}
		public void setOnclick(String onclick) {this.onclick = onclick;}
		
		public String getOnrollover() {return onrollover;}
		public void setOnrollover(String onrollover) {this.onrollover = onrollover;}
		
		public boolean getIsPrimaryDB() {return isprimaryBD;}
		public void setIsprimaryBD(boolean isprimaryBD) {this.isprimaryBD = isprimaryBD;}
		
		public BOBFormat getFormat() {return format;}
		public void setFormat(BOBFormat format) {this.format = format;}
		
		public List<BOBHtmlElement> getChildren() {return children;}
		public void setChildren(List<BOBHtmlElement> children) {this.children = children;}
		
		public BOBHtmlElement getWraper() {	return wraper;}
		public void setWraper(BOBHtmlElement wraper) {this.wraper = wraper;}
		
		public String getCssClass() {return cssClass;}
		public void setCssClass(String cssClass) {this.cssClass = cssClass;}

		public String getWidth() {return width;}
		public void setWidth(String width) {this.width = width;}

		public String getBackgroundColor() {return backgroundColor;}
		public void setBackgroundColor(String backgroundColor) {this.backgroundColor = backgroundColor;}

		public String getRecursoUrl() {return recursoUrl;}
		public void setRecursoUrl(String recursoUrl) {this.recursoUrl = recursoUrl;}

		public boolean getSeleted() {return seleted;}
		public void setSeleted(boolean seleted) {this.seleted = seleted;}

		public String getTitle() {return title;}
		public void setTitle(String title) {this.title = title;}


		@Override
		public String toString() {
			return "BOBHtmlElement [tag=" + tag + ", type=" + type + ", id=" + id + ", name=" + name + ", value="
					+ value + ", cssClass=" + cssClass + ", backgroundColor=" + backgroundColor + ", width=" + width
					+ ", required=" + required + ", label=" + label + ", rows=" + rows + ", col=" + col + ", content="
					+ content + ", href=" + href + ", recursoUrl=" + recursoUrl + ", onclick=" + onclick
					+ ", onrollover=" + onrollover + ", isprimaryBD=" + isprimaryBD + ", seleted=" + seleted
					+ ", format=" + format + ", children=" + children
					+ ", wraper=" + wraper
					+ ", title=" + title + "]";
		}

		
}
