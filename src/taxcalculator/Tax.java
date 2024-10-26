package taxcalculator;

public class Tax {
		int id;
		String name;
		double income;
		double taxRate;
		public Tax(int id, String name, double income) {
			super();
			this.id = id;
			this.name = name;
			this.income = income;

		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public double getIncome() {
			return income;
		}
		public void setIncome(double income) {
			this.income = income;
		}

}
