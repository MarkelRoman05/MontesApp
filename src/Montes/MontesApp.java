package Montes;
import java.io.*;
import java.sql.*;
import java.util.Scanner;


import Montes.*;
public class MontesApp {
	public static Scanner teklatua = new Scanner(System.in);
	private static Montes[] montesList;
	private static int kont_montes;
	
	public static void main(String[] args) {
		
		int auk = 0;
		
		boolean trycatch = false;
		boolean amaitu = false;
		
		int alturaMonte = 0;
		
		String nombMonte = "";
		String provincMonte = "";
		String coordMonte = "";
		String cordillMonte = "";
		String rutaMonte = "";
		
		String nombMonteBorrar = "";
		String nombMonteBuscar = "";
		
		do {
			System.out.println("**** MENUA ****");
			System.out.println("1. Cargar montes (txt).");
			System.out.println("2. Cargar montes (BD).");
			System.out.println("3. Añadir monte.");
			System.out.println("4. Mostrar montes.");
			System.out.println("5. Mostrar monte por nombre.");
			System.out.println("6. Eliminar monte.");
			System.out.println("7. Guardar montes (BD).");
			System.out.println("8. Escribir montes en File.");
			System.out.println("0. FIN PROGRAMA.");
			do {
				System.out.println("Sartu aukera bat (0-7):");
				try {
					auk = Integer.parseInt(teklatua.nextLine());
					if (auk >= 0 && auk <= 7) {
						trycatch = true;
					} else {
						System.out.println("Sartu aukera ondo!");
						trycatch = false;
					}
				} catch (Exception ex) {
					System.out.println("Txarto sartuta!");
					trycatch = false;
				}
			} while (!trycatch);
			trycatch = false;
			switch (auk) {
				case 0:
					System.out.println("PROGRAMA AMAITZEN...");
					amaitu = true;
					break;
				case 1:
					File oFile = new File("montes.txt");
					//FileReader oFileReader = new FileReader(oFile); 
					int i = 0;
					/*while ((i = oFileReader.read()) != -1) {
			 			System.out.println((char) i + "==>" + i);
					}
					oFileReader.close(); */
				
						
			
					
					break;
				case 2:
					getMontes();
					getMontesCount();
					System.out.println("MONTES CARGADOS DE LA BD!");
					System.out.println(kont_montes);
					break;
				case 3:
					System.out.println("*AÑADIR MONTE*");
					do {
						System.out.println("Escribe el nombre: ");
						try {
							nombMonte = teklatua.nextLine();
							trycatch = true;
							
						} catch (Exception ex) {
							System.out.println("Txarto sartuta!");
							trycatch = false;
						}
					} while (!trycatch);
					trycatch = false;
					do {
						System.out.println("Escribe provincia: ");
						try {
							provincMonte = teklatua.nextLine();
							trycatch = true;
							
						} catch (Exception ex) {
							System.out.println("Txarto sartuta!");
							trycatch = false;
						}
					} while (!trycatch);
					trycatch = false;
					do {
						System.out.println("Escribe altura (0-3500 m): ");
						try {
							alturaMonte = Integer.parseInt(teklatua.nextLine());
							if (alturaMonte >= 0 && alturaMonte <= 3500) {
								trycatch = true;
							} else {
								System.out.println("Sartu aukera ondo!");
								trycatch = false;
							}
						} catch (Exception ex) {
							System.out.println("Txarto sartuta!");
							trycatch = false;
						}
					} while (!trycatch);
					trycatch = false;
					do {
						System.out.println("Escribe coordenadas: ");
						try {
							coordMonte = teklatua.nextLine();
							trycatch = true;
							
						} catch (Exception ex) {
							System.out.println("Txarto sartuta!");
							trycatch = false;
						}
					} while (!trycatch);
					trycatch = false;
					do {
						System.out.println("Escribe cordillera: ");
						try {
							cordillMonte = teklatua.nextLine();
							trycatch = true;
							
						} catch (Exception ex) {
							System.out.println("Txarto sartuta!");
							trycatch = false;
						}
					} while (!trycatch);
					trycatch = false;
					do {
						System.out.println("Escribe ruta: ");
						try {
							rutaMonte = teklatua.nextLine();
							trycatch = true;
							
						} catch (Exception ex) {
							System.out.println("Txarto sartuta!");
							trycatch = false;
						}
					} while (!trycatch);
					
					Montes nuevoMonte = new Montes(nombMonte, provincMonte, alturaMonte, coordMonte, cordillMonte, rutaMonte);

				    Montes[] nuevoMontesList = new Montes[montesList.length + 1];
				    for (int o = 0; o < montesList.length; o++) {
				    	nuevoMontesList[o] = montesList[o];
				    }
				    	montesList = nuevoMontesList;
				    

				    montesList[montesList.length - 1] = nuevoMonte;
					
					break;
				case 4:
					for (int h = 0; h < montesList.length; h++) {
						System.out.println(montesList[h].toString());
					}
					break;
				case 5:
					trycatch = false;
					do {
						System.out.println("Escribe nombre monte a buscar: ");
						try {
							nombMonteBuscar = teklatua.nextLine();
							trycatch = true;
							
						} catch (Exception ex) {
							System.out.println("Txarto sartuta!");
							trycatch = false;
						}
					} while (!trycatch);
					
					for (int x = 0; x < montesList.length; x++) {
						if (montesList[x].getNombreMonte().equalsIgnoreCase(nombMonteBuscar)) {
							System.out.println(montesList[x].toString());
						}
					}
					
					break;
				case 6:
					trycatch = false;
					do {
						System.out.println("Escribe nombre monte a borrar: ");
						try {
							nombMonteBorrar = teklatua.nextLine();
							trycatch = true;
							
						} catch (Exception ex) {
							System.out.println("Txarto sartuta!");
							trycatch = false;
						}
					} while (!trycatch);
					
					
					
					int indiceMonteEliminar = -1;
					
					for (int y = 0; y < montesList.length; y++) {
						if (montesList[y].getNombreMonte().equalsIgnoreCase(nombMonteBorrar)) {
							indiceMonteEliminar = y;
							break;
						}
					}
					
					
					Montes[] nuevoElimMonteList = new Montes[montesList.length - 1];
					for (int c = 0, j = 0; c < montesList.length; c++) {
					    if (c != indiceMonteEliminar) {
					    	nuevoElimMonteList[j++] = montesList[c];
					    }
					}
					
					break;
				case 7:
				    System.out.println("GUARDAR MONTES EN LA BASE DE DATOS");
				    String url = "jdbc:mysql://localhost:3306/montes";
				    String user = "root";
				    String password = "";
				    
				    try (Connection conn = DriverManager.getConnection(url, user, password)) {
				        
				        String deleteQuery = "DELETE FROM montes";
				        try (PreparedStatement deleteStmt = conn.prepareStatement(deleteQuery)) {
				            deleteStmt.executeUpdate();
				            System.out.println("Los montes existentes se han eliminado de la base de datos correctamente.");
				        } catch (SQLException e) {
				            System.err.println("Error al ejecutar la consulta SQL de eliminación: " + e.getMessage());
				        }
				    
				        String insertQuery = "INSERT INTO montes (Nombre, Provincia, Altura, Coordenadas, Cordillera, Ruta) VALUES (?, ?, ?, ?, ?, ?)";
				        try (PreparedStatement pstmt = conn.prepareStatement(insertQuery)) {
				            for (int k = 0; k < montesList.length; k++) {
				                Montes monte = montesList[k];
				                pstmt.setString(1, monte.getNombreMonte());
				                pstmt.setString(2, monte.getProvincia());
				                pstmt.setInt(3, monte.getAltura());
				                pstmt.setString(4, monte.getCoordenadas());
				                pstmt.setString(5, monte.getCordillera());
				                pstmt.setString(6, monte.getRuta());
				                pstmt.executeUpdate();
				            }
				            System.out.println("Los montes se han guardado en la base de datos correctamente.");
				        } catch (SQLException e) {
				            System.err.println("Error al ejecutar la consulta SQL: " + e.getMessage());
				        }
				    } catch (SQLException e) {
				        System.err.println("Error al conectar con la base de datos: " + e.getMessage());
				    }
				    break;
				
			}
		} while (!amaitu);

		teklatua.close();
	}
	public static void getMontes() {
		getMontesCount();
		montesList = new Montes[kont_montes];

		int kont = 0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String url = "jdbc:mysql://localhost:3306/montes";
			String user = "root";
			String pass = "";
			
			
			Connection conn = DriverManager.getConnection(url, user, pass);
			
			Statement sta = conn.createStatement();
			String sqlk = "SELECT Nombre n, Provincia p, Altura a, Coordenadas c, Cordillera co, Ruta r FROM montes";
			ResultSet res = sta.executeQuery(sqlk);
			
			while(res.next()) {
				Montes monteAux = new Montes(res.getString("n"), res.getString("p"), res.getInt("a"), res.getString("c"), res.getString("co"), res.getString("r"));
				
				montesList[kont] = monteAux;
				kont++;
			}
			
			res.close();
			sta.close();
			conn.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public static void getMontesCount() {
		String url = "jdbc:mysql://localhost:3306/montes";
		String user = "root";
		String pass = "";
		
		String kontsulta = "SELECT count(*) FROM montes";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection conn = DriverManager.getConnection(url, user, pass);
			
			Statement sta = conn.createStatement();
			ResultSet emaitza = sta.executeQuery(kontsulta);
			
			
			emaitza = sta.executeQuery(kontsulta);
			while (emaitza.next()) {
				kont_montes = emaitza.getInt("count(*)");
			}
		
			emaitza.close();
			sta.close();
			conn.close();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {	
			e.printStackTrace();
		}
		
	}
}



