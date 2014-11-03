package
{
	import mx.controls.dataGridClasses.DataGridColumn;
	import mx.core.ClassFactory;
	
	public class StylizedDataGridColumn extends DataGridColumn
	{
		
		public function StylizedDataGridColumn()
		{
			super();
			this.itemRenderer = new ClassFactory( StylizedDataGridItemRenderer );
		}
		
		public var stylesFunction:Function
		
	}
}