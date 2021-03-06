package it.padova.sanita.bedmanbe.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="CC_RILEVAZIONI", schema="scott")
@SequenceGenerator(name="IdRilevazioneSequenceGen",sequenceName="ID_RIL_SEQ",allocationSize=1,initialValue=1)
public class Rilevazione
{	
	public Rilevazione(Long ril_id, int ril_str_str, int ril_ric_anno, int ril_ric_cartella,
			int ril_ass_ipca, 
			String ril_tipo, String ril_val, String ril_note, Date ril_data,
			String ril_ute_ins, Date ril_data_ins, String ril_reparto_ass) {
		
		this.ril_id = ril_id;
		this.ril_str_str = ril_str_str;
		this.ril_ric_anno = ril_ric_anno;
		this.ril_ric_cartella = ril_ric_cartella;
		this.ril_ass_ipca = ril_ass_ipca;
		this.ril_tipo = ril_tipo;
		this.ril_val = ril_val;
		this.ril_note = ril_note;
		this.ril_data = ril_data;
		this.ril_ute_ins = ril_ute_ins;
		this.ril_data_ins = ril_data_ins;
		this.ril_reparto_ass = ril_reparto_ass;
	}
	
	public Rilevazione() {
	}
	
	private Long ril_id;

	private int ril_str_str;

	private int ril_ric_anno;

	private int ril_ric_cartella;
	
	private int ril_ass_ipca;

	private String ril_tipo;
	
	private String ril_val;
	
	private String ril_note;
	
	private Date ril_data;
	
	private String ril_ute_ins;
	
	private Date ril_data_ins;
	
	private String ril_reparto_ass;
	
	//private Long deg_Id;
	
	private Degente degente;

	@Id
	@Column(name="RIL_ID", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "IdRilevazioneSequenceGen")
	public Long getRil_Id()
	{
		return ril_id;
	}

	public void setRil_Id(Long ril_id)
	{
		this.ril_id = ril_id;
	}

	@Column(name="RIL_STR_STR", nullable = false, precision = 5, scale = 0)
	public int getRil_Str_Str()
	{
		return ril_str_str;
	}

	public void setRil_Str_Str(int ril_str_str)
	{
		this.ril_str_str = ril_str_str;
	}
	
	@Column(name="RIL_RIC_ANNO", nullable = false, precision = 4, scale = 0)
	public int getRil_Ric_Anno()
	{
		return ril_ric_anno;
	}

	public void setRil_Ric_Anno(int ril_ric_anno)
	{
		this.ril_ric_anno = ril_ric_anno;
	}
	
	@Column(name="RIL_RIC_CARTELLA", nullable = false, precision = 12, scale = 0)
	public int getRil_Ric_Cartella()
	{
		return ril_ric_cartella;
	}

	
	public void setRil_Ric_Cartella(int ril_ric_cartella)
	{
		this.ril_ric_cartella = ril_ric_cartella;
	}
	
	@Column(name="RIL_ASS_IPCA", nullable = false, precision = 8, scale = 0)
	public int getRil_ass_ipca() {
		return ril_ass_ipca;
	}

	public void setRil_ass_ipca(int ril_ass_ipca) {
		this.ril_ass_ipca = ril_ass_ipca;
	}

	@Column(name="RIL_TIPO", nullable = false, length = 2)
	public String getRil_tipo() {
		return ril_tipo;
	}

	public void setRil_tipo(String ril_tipo) {
		this.ril_tipo = ril_tipo;
	}

	@Column(name="RIL_VAL", nullable = false, length = 30)
	public String getRil_val() {
		return ril_val;
	}

	public void setRil_val(String ril_val) {
		this.ril_val = ril_val;
	}

	@Column(name="RIL_NOTE", nullable = true, length = 500)
	public String getRil_note() {
		return ril_note;
	}

	public void setRil_note(String ril_note) {
		this.ril_note = ril_note;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "RIL_DATA", nullable = true, length = 19)
	public Date getRil_data() {
		return ril_data;
	}

	public void setRil_data(Date ril_data) {
		this.ril_data = ril_data;
	}

	@Column(name = "RIL_UTE_INS", nullable = false, length = 12)
	public String getRil_ute_ins() {
		return ril_ute_ins;
	}

	public void setRil_ute_ins(String ril_ute_ins) {
		this.ril_ute_ins = ril_ute_ins;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "RIL_DATA_INS", nullable = true, length = 19)
	public Date getRil_Data_Ins() {
		return ril_data_ins;
	}
 
	public void setRil_Data_Ins(Date ril_data_ins) {
		this.ril_data_ins = ril_data_ins;
	}
	
	@Column(name="RIL_REPARTO_ASS", nullable = true, length = 6)
	public String getRil_Reparto_Ass() {
		return ril_note;
	}

	public void setRil_Reparto_Ass(String ril_reparto_ass) {
		this.ril_reparto_ass = ril_reparto_ass;
	}
	
//	@Column(name="DEG_ID")
//	public Long getDeg_Id() {
//		return deg_Id;
//	}
//
//	public void setDeg_Id(Long deg_Id) {
//		this.deg_Id = deg_Id;
//	}

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="DEG_ID")
	public Degente getDegente() {
		return degente;
	}

	public void setDegente(Degente degente) {
		this.degente = degente;
	}

}
