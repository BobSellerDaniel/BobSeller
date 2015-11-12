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
		private String classs;	
		private String required;
		private String label;
		private String rows;
		private String col;
		private String content;
		private String drawIf;
		private String href;
		private String onclick;
		private String onrollover;
		private boolean isprimaryBD;
		private BOBFormat format;
		private List<BOBHtmlElement> children;
		private BOBHtmlElement wraper;
		
		
		public BOBHtmlElement(){
			
		}
		public BOBHtmlElement(BOBHtmlTag tag, String label, boolean primary, BOBFormat format) {
			setTag(tag);
			setLabel(label);
			setIsprimaryBD(primary);
			setFormat(format);

		}
		public BOBHtmlTag getTag() {
			return tag;
		}
		public void setTag(BOBHtmlTag tag) {
			this.tag = tag;
		}
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getValue() {
			return value;
		}
		public void setValue(String value) {
			this.value = value;
		}
		public String getClasss() {
			return classs;
		}
		public void setClasss(String classs) {
			this.classs = classs;
		}
		public String getRequired() {
			return required;
		}
		public void setRequired(String required) {
			this.required = required;
		}
		public String getLabel() {
			return label;
		}
		public void setLabel(String label) {
			this.label = label;
		}
		public String getRows() {
			return rows;
		}
		public void setRows(String rows) {
			this.rows = rows;
		}
		public String getCol() {
			return col;
		}
		public void setCol(String col) {
			this.col = col;
		}
		public String getContent() {
			return content;
		}
		public void setContent(String content) {
			this.content = content;
		}
		public String getDrawIf() {
			return drawIf;
		}
		public void setDrawIf(String drawIf) {
			this.drawIf = drawIf;
		}
		public String getHref() {
			return href;
		}
		public void setHref(String href) {
			this.href = href;
		}
		public String getOnclick() {
			return onclick;
		}
		public void setOnclick(String onclick) {
			this.onclick = onclick;
		}
		public String getOnrollover() {
			return onrollover;
		}
		public void setOnrollover(String onrollover) {
			this.onrollover = onrollover;
		}
		public boolean isIsprimaryBD() {
			return isprimaryBD;
		}
		public void setIsprimaryBD(boolean isprimaryBD) {
			this.isprimaryBD = isprimaryBD;
		}
		public BOBFormat getFormat() {
			return format;
		}
		public void setFormat(BOBFormat format) {
			this.format = format;
		}
		public List<BOBHtmlElement> getChildren() {
			return children;
		}
		public void setChildren(List<BOBHtmlElement> children) {
			this.children = children;
		}
		public BOBHtmlElement getWraper() {
			return wraper;
		}
		public void setWraper(BOBHtmlElement wraper) {
			this.wraper = wraper;
		}
		@Override
		public String toString() {
			return "BOBHtmlElement [tag=" + tag + ", type=" + type + ", id=" + id + ", name=" + name + ", value="
					+ value + ", classs=" + classs + ", required=" + required + ", label=" + label + ", rows=" + rows
					+ ", col=" + col + ", content=" + content + ", drawIf=" + drawIf + ", href=" + href + ", onclick="
					+ onclick + ", onrollover=" + onrollover + ", isprimaryBD=" + isprimaryBD + ", format=" + format
					+ ", children=" + children + ", wraper=" + wraper + "]";
		}

		
		

		
				
}
