package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the geometry_columns database table.
 * 
 */
@Entity
@Table(name="geometry_columns")
@NamedQuery(name="GeometryColumn.findAll", query="SELECT g FROM GeometryColumn g")
public class GeometryColumn implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer coordDimension;
	private String fGeometryColumn;
	private String fTableCatalog;
	private String fTableName;
	private String fTableSchema;
	private Integer srid;
	private String type;

	public GeometryColumn() {
	}


	@Column(name="coord_dimension")
	public Integer getCoordDimension() {
		return this.coordDimension;
	}

	public void setCoordDimension(Integer coordDimension) {
		this.coordDimension = coordDimension;
	}


	@Column(name="f_geometry_column", length=256)
	public String getFGeometryColumn() {
		return this.fGeometryColumn;
	}

	public void setFGeometryColumn(String fGeometryColumn) {
		this.fGeometryColumn = fGeometryColumn;
	}


	@Column(name="f_table_catalog", length=256)
	public String getFTableCatalog() {
		return this.fTableCatalog;
	}

	public void setFTableCatalog(String fTableCatalog) {
		this.fTableCatalog = fTableCatalog;
	}


	@Column(name="f_table_name", length=256)
	public String getFTableName() {
		return this.fTableName;
	}

	public void setFTableName(String fTableName) {
		this.fTableName = fTableName;
	}


	@Column(name="f_table_schema", length=256)
	public String getFTableSchema() {
		return this.fTableSchema;
	}

	public void setFTableSchema(String fTableSchema) {
		this.fTableSchema = fTableSchema;
	}


	public Integer getSrid() {
		return this.srid;
	}

	public void setSrid(Integer srid) {
		this.srid = srid;
	}


	@Column(length=30)
	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

}