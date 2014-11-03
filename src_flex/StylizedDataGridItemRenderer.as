package
{
	import flash.text.TextFormat;
	
	import mx.controls.DataGrid;
	import mx.controls.dataGridClasses.DataGridItemRenderer;
	import mx.controls.dataGridClasses.DataGridListData;
	
	public class StylizedDataGridItemRenderer extends DataGridItemRenderer
	{
		public function StylizedDataGridItemRenderer()
		{
			super();
		}
		
		private var lastUID:String;	
		
		override public function set data(value:Object):void
		{
			super.data = value;
			
			if (listData && listData.uid != lastUID)
			{
				styleChanged("color");
				lastUID = listData.uid;
			}
		}
		
		override public function getTextStyles():TextFormat
		{
			if (!listData) 
			{
				return super.getTextStyles();
			}
			
			var tf:TextFormat = super.getTextStyles();
			
			var dgListData:DataGridListData = listData as DataGridListData;
			var dataGrid:DataGrid = dgListData.owner as DataGrid;
			var column:StylizedDataGridColumn = dataGrid.columns[dgListData.columnIndex];
			var o:Object = column.stylesFunction(data, column);
			
			for (var p:String in o)
			{
				tf[p] = o[p];
			}
			
			return tf;
			
		}
		
		
	}
}