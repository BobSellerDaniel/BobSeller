package core.component;

import java.util.List;

import javax.persistence.Entity;


/** Modelado de un elemento HTML:  la presente clase se transfiere a la vista y tiene como finalidad describir todos los 
 * atributos de un Tag Html por ejemplo un <input>.
 * @author daniel */
@Entity
public class BOBHtmlElement {

		private BOBHtmlTag tag;
		private String type;
		private String id;
		private String name;
		private String value;
		private String cssClass;
		private String width;
		private String required;
		private String label;
		private String rows;
		private String col;
		private String content;
		private String href;
		private String recursoUrl;
		private String onclick;
		private String onrollover;
		private boolean isprimaryBD;
		private BOBFormat format;
		private List<BOBHtmlElement> children;
		private BOBHtmlElement wraper;
		
		public BOBHtmlElement(){}
		
		public BOBHtmlElement(BOBHtmlTag tag, String type, String id, String name, String value, String cssClass,
				String width, String required, String label, String rows, String col, String content, String href, String recursoUrl,
				String onclick, String onrollover, boolean isprimaryBD, BOBFormat format, List<BOBHtmlElement> children,
				BOBHtmlElement wraper) {
			super();
			this.tag = tag;
			this.type = type;
			this.id = id;
			this.name = name;
			this.value = value;
			this.cssClass = cssClass;
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
			this.format = format;
			this.children = children;
			this.wraper = wraper;
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
			BOBHtmlElement th = new BOBHtmlElement(BOBHtmlTag.th, null, id, null, null, cssClass, widths,
					null, label, null, null, null, null, null, null, null, isprimaryBD, null, null, null);
			return th;
		}
		
		public static BOBHtmlElement getTab(String label, String id, String cssClass, String recursoUrl){
			BOBHtmlElement tab = new BOBHtmlElement(BOBHtmlTag.tab, null, id, null, null, cssClass,
					null,null, label, null, null, null, null, recursoUrl,
					null, null, false, null, null,null);
			return tab;
		} 
		
		
		
		public boolean drawIf(){return true;}
		
		public BOBHtmlTag getTag() {return tag;}
		public void setTag(BOBHtmlTag tag) {this.tag = tag;}
		
		public String getType() {return type;}
		public void setType(String type) {this.type = type;}
		
		public String getId() {return id;}
		public void setId(String id) {this.id = id;}
		
		public String getName() {return name;}
		public void setName(String name) {this.name = name;}
		
		public String getValue() {return value;}
		public void setValue(String value) {this.value = value;}
		
		public String getCssClasss() {return cssClass;}
		public void setCssClasss(String classs) {this.cssClass = classs;}
		
		public String getRequired() {return required;}
		public void setRequired(String required) {this.required = required;}
		
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
		
		public boolean isIsprimaryBD() {return isprimaryBD;}
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

		@Override
		public String toString() {
			return "BOBHtmlElement [tag=" + tag + ", type=" + type + ", id=" + id + ", name=" + name + ", value="
					+ value + ", cssClass=" + cssClass + ", width=" + width + ", required=" + required + ", label="
					+ label + ", rows=" + rows + ", col=" + col + ", content=" + content + ", href=" + href
					+ ", onclick=" + onclick + ", onrollover=" + onrollover + ", isprimaryBD=" + isprimaryBD
					+ ", format=" + format + ", children=" + children + ", wraper=" + wraper + "]";
		}
}
