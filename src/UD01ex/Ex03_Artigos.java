package UD01ex;

public class Ex03_Artigos {

	public static void main(String[] args) {

	}

	class Artigos {
		private int CODIGO;
		private String description;
		private double PVP;
		private int stock;
		private int minStock;

		
		public Artigos(int cODIGO, String description, double pVP, int stock, int minStock) {
			CODIGO = cODIGO;
			this.description = description;
			PVP = pVP;
			this.stock = stock;
			this.minStock = minStock;
		}

		public int getCODIGO() {
			return CODIGO;
		}

		public void setCODIGO(int cODIGO) {
			CODIGO = cODIGO;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public double getPVP() {
			return PVP;
		}

		public void setPVP(double pVP) {
			PVP = pVP;
		}

		public int getStock() {
			return stock;
		}

		public void setStock(int stock) {
			this.stock = stock;
		}

		public int getMinStock() {
			return minStock;
		}

		public void setMinStock(int minStock) {
			this.minStock = minStock;
		}

		boolean seekArticle(int code) {
			boolean thereIs = false;
			if (code == this.CODIGO)
				thereIs = true;
			return thereIs;
		}

		void minArticle() {
			if (this.stock <= this.minStock)
				System.out.println("Realizar pedido de " + description);
		}

	}

}
