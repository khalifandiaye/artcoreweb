package fr.afcepf.al22.gestionpersonne.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import fr.afcepf.al22.gestionpersonne.entity.Personne;
import fr.afcepf.al22.gestionpersonne.util.UtilCnxAl22;

public class DaoPersonneImpl implements IDaoPersonne {
	private DataSource dsAl22 = new UtilCnxAl22();
//	private final String reqAjout =
//		"INSERT INTO personne (nom, mail, mdp, naissance) "
//	  + "VALUES (?,?,?,?)";
	private final String reqCnx =
		"SELECT * FROM client WHERE mail = ? "
	  + "AND mdp = ?";
	private final String reqRechercher =
		"SELECT * FROM client WHERE nom_client like ?";
			
	

//	@Override
//	public Personne cnx(String mail, String mdp) {
//		Personne p = null;
//		try {
//			Connection cnx = dsAl22.getConnection();
//			PreparedStatement pstmt =
//					cnx.prepareStatement(reqCnx);
//			pstmt.setString(1, mail);
//			pstmt.setString(2, mdp);
//			ResultSet rs = pstmt.executeQuery();
////			Statement pstmt = cnx.createStatement();
////			ResultSet rs = pstmt.executeQuery(
////					"SELECT * FROM personne WHERE "
////					+ "mail = '" + mail + "' "
////					+ "AND mdp = '" + mdp + "'"
////					);
//			if (rs.next()) {
//				p = rsToPersonne(rs);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return p;
//	}

	@Override
	public List<Personne> rechercher(String nom) {
		List<Personne> liste = new ArrayList<Personne>();
		try {
			Connection cnx = dsAl22.getConnection();
			PreparedStatement pstmt =
					cnx.prepareStatement(reqRechercher);
			pstmt.setString(1, "%" + nom + "%");
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				liste.add(rsToPersonne(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return liste;
	}

	private Personne rsToPersonne(ResultSet rs) {
		Personne p = null;
		try {
			p = new Personne(rs.getInt("id_client"),
							rs.getInt("id_utilisateur"),
							rs.getInt("id_civilite"),
							rs.getInt("id_professionnel"),
							rs.getString("nom_client"), 
							 rs.getString("prenom_client"),
							 rs.getString("mail_client"),
							 rs.getString("tel_client"),
							 new java.util.Date(rs.getDate("date_naissance").getTime()),
							 rs.getDate("date_fin_activite")
							);
			System.out.println("Personne : "+p.getNom()+" date "+rs.getDate("date_naissance")+" date objet "+p.getNaissance() );
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return p;
	}

	//@Override
//	public Personne ajouter(Personne pers) {
//		Connection cnx = null;
//		try {
//			cnx = dsAl22.getConnection();
//			PreparedStatement pstmt =
//					cnx.prepareStatement(reqAjout,
//							Statement.RETURN_GENERATED_KEYS);
//			pstmt.setString(1, pers.getNom());
//			pstmt.setString(2, pers.getMail());
//			pstmt.setString(3, pers.getMdp());
//			pstmt.setDate(4, new java.sql.Date(
//					pers.getNaissance().getTime()));
//			int retour = pstmt.executeUpdate();
//			ResultSet rs = pstmt.getGeneratedKeys();
//			if(retour == 1 && rs.next()) {
//				pers.setId(rs.getInt(1));
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				cnx.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//		return pers;
//	}
}
