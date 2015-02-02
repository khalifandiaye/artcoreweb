/**
 * 
 */
package fr.afcepf.al22.orchestration.entities;

import java.util.List;

/**
 * @author Stagiaire
 *
 */
public class CheckResultProduitCommande {
	
	private List<ProduitCommande> listeProduits;
	private boolean alerteCB;
	private String alertePolice;
	/**
	 * @return the listeProduits
	 */
	public List<ProduitCommande> getListeProduits() {
		return listeProduits;
	}
	/**
	 * @param listeProduits the listeProduits to set
	 */
	public void setListeProduits(List<ProduitCommande> listeProduits) {
		this.listeProduits = listeProduits;
	}
	
	/**
	 * @return the alertePolice
	 */
	public String getAlertePolice() {
		return alertePolice;
	}
	/**
	 * @param alertePolice the alertePolice to set
	 */
	public void setAlertePolice(String alertePolice) {
		this.alertePolice = alertePolice;
	}
	/**
	 * @return the alerteCB
	 */
	public boolean isAlerteCB() {
		return alerteCB;
	}
	/**
	 * @param alerteCB the alerteCB to set
	 */
	public void setAlerteCB(boolean alerteCB) {
		this.alerteCB = alerteCB;
	}
	
	
	
}
