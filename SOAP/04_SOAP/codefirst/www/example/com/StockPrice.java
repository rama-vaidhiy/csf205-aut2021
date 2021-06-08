package www.example.com;

public class StockPrice {

	
	public float getStockValue(String tickerName, float defValue)
	{
		if(null!=tickerName && !(tickerName.isBlank()) && tickerName.equalsIgnoreCase("ORCL"))
		{
			return 82.40f;
		}
		return defValue;
	}
	
	
}
