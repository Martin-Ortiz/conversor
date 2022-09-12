package conversor;

import javax.swing.JOptionPane;

public class Conversor{
	private String seleccionMenu;
	private double cantidad;
	private String menuDeConversion;
	private String tipoDeCambio;
	private double resultado;
	
	public Conversor() {
		try {
			iniciarMenu();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Proceso finalizado");
		}
		
	}
	
	public void iniciarMenu() {
		
		this.seleccionMenu = (JOptionPane.showInputDialog(null, "Seleciona el tipo de conversor", "Menú",
						JOptionPane.PLAIN_MESSAGE, null,
						new Object[] { "Conversor de moneda", "Conversor de temperatura", "conversor de medidas" },
						"Selecciona")).toString();
		setCantidad();
		
		setMenuDeConversion(this.seleccionMenu);
		
		setResultado(this.menuDeConversion, this.cantidad);
		
		mensajeResultado(this.resultado, this.tipoDeCambio);
		
		terminarPrograma();
		
	}
	
	public void setCantidad() {
		
		boolean esNumero = false;
		
		while (!esNumero) {
			try {
				this.cantidad = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingresa la cantidad que deseas convertir:"));
				esNumero = true;
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null,"Debes de ingresar un numero valido");
				System.out.println(e);
			}
		}
	}
		 
	public void setMenuDeConversion (String menu) {
		if(menu == "Conversor de moneda") {
			
			this.menuDeConversion = (JOptionPane.showInputDialog(null,
					"Elige la moneda a la que deseas convertir tu dinero:", "Monedas", JOptionPane.PLAIN_MESSAGE, null,
					new Object[] { "De Pesos a Dólar", "De Pesos a Euro", "De Pesos a Libras", "De Pesos a Yen",
							"De Pesos a Won Surcoreano", "De Dólar a Pesos", "De Euro a Pesos", "De Libras a Pesos" },
					"Selecciona")).toString();
			
		}else if(menu == "Conversor de temperatura") {
			
			this.menuDeConversion = (JOptionPane.showInputDialog(null,
					"Elige el tipo de temperatura que deseas convertir:", "Temperatura", JOptionPane.PLAIN_MESSAGE, null,
					new Object[] { "De Celcius a Kelvin", "De Celcius a Farenheit", "De kelvin a Celcius",
							"De Kelvin a Farenheit", "De Farenheit a Celcius", "De Farenheit a Kelvin" },
					"Selecciona")).toString();
			
			
		}else if(menu == "conversor de medidas") {
			this.menuDeConversion = (JOptionPane.showInputDialog(null,
					"Elige el tipo de medida que deseas convertir:", "Unidades de Medida", JOptionPane.PLAIN_MESSAGE, null,
					new Object[] { "De Centimetros a milimetros", "De Centimetros a Metros",
							"De Centimetros a kilometros", "De centimetros a Pulgadas", "De Kilometros a metros", "De Pulgadas a Centimetros" },
					"Selecciona")).toString();
		}
	}
	
	public void setResultado(String menuDeConversion, double cantidad) {
		
		switch (menuDeConversion) {
		
		// conversor de monedas
		case "De Pesos a Dólar":
			this.resultado = 0.05 * cantidad;
			this.tipoDeCambio = " Dolares";
			break;
			
		case "De Pesos a Euro":
			this.resultado = 0.05 * cantidad;
			this.tipoDeCambio = " Euros";
			break;
			
		case "De Pesos a Libras":
			this.resultado = 0.043 * cantidad;
			this.tipoDeCambio = " Libras";
			break;
			
		case "De Pesos a Yen":
			this.resultado = 7.16 * cantidad;
			this.tipoDeCambio = " Yenes";
			break;
			
		case "De Pesos a Won Surcoreano":
			this.resultado = 69.21 * cantidad;
			this.tipoDeCambio = " Wones";
			break;
			
		case "De Dólar a Pesos":
			this.resultado = 19.84 * cantidad;
			this.tipoDeCambio = " Pesos MX";
			break;
			
		case "De Euro a Pesos":
			this.resultado = 20.11 * cantidad;
			this.tipoDeCambio = " Pesos MX";
			break;
			
		case "De Libras a Pesos":
			this.resultado = 23.22 * cantidad;
			this.tipoDeCambio = " Pesos MX";
			break;
			
		// conversor de temperatura
		case "De Celcius a Kelvin":
			this.resultado = cantidad + 273.15;
			this.tipoDeCambio = " K";
			break;
			
		case "De Celcius a Farenheit":
			this.resultado = ( cantidad * (1.8) ) + 32;
			this.tipoDeCambio = " °F";
			break;
			
		case "De kelvin a Celcius":
			this.resultado = cantidad - 273.15;
			this.tipoDeCambio = " °C";
			break;
			
		case "De Kelvin a Farenheit":
			this.resultado = ( (cantidad - 273.15) * (1.8) ) + 32;
			this.tipoDeCambio = " °F";
			break;
			
		case "De Farenheit a Celcius":
			this.resultado = ( cantidad - 32) * (0.555555556);
			this.tipoDeCambio = " °C";
			break;
			
		case "De Farenheit a Kelvin":
			this.resultado = ( ( cantidad - 32) * 0.555555556 ) + 273.15;
			this.tipoDeCambio = " K";
			break;
			
		// conversor de medidas
			
			
		default:
			this.resultado = 0;
			this.tipoDeCambio = " Seguimos en desarrollo! ;-)";
			break;
		}
	}
	
	public void mensajeResultado(double resultado, String tipoDeCambio) {
		JOptionPane.showMessageDialog(null, "Tienes: " + resultado + tipoDeCambio, "Resultado", JOptionPane.PLAIN_MESSAGE);
	}
	
	public void terminarPrograma() {
		
		int deseaFinalizar = JOptionPane.showConfirmDialog(null, "¿Desea cotinuar?");
		
		if(deseaFinalizar == 0) {
			iniciarMenu();
		} else {
			JOptionPane.showMessageDialog(null, "Finalizar programa.");
		}
	}
		 
		 
		
		
}
