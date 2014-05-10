package br.fafica.pi1.rightcode.factory;



/*
 * DataSourceFactoy � respons�vel por criar as f�bricas de DAOs de um determinado tipo.
 */

public class DataSourceFactory {

	private DataSourceType type;
	
	public DataSourceFactory() {
		// Definimos aqui aqual � o tipo de DAO que usaremos
		this.type = DataSourceType.ARRAYLIST;
	}
	
	public DataSourceType getType() {
		return type;
	}

	public void setType(DataSourceType type) {
		this.type = type;
	}

	public IFactory getDataSource() {
		switch (type) {
		case ARRAYLIST:
			return new FactoryArrayList();
		case ORACLE:
			return new FactoryOracle();
		default:
			return new FactoryArrayList();
		}
		
	}
}