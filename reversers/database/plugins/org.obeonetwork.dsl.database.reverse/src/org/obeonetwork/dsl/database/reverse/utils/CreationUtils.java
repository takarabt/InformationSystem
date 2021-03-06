package org.obeonetwork.dsl.database.reverse.utils;

import org.obeonetwork.dsl.database.AbstractTable;
import org.obeonetwork.dsl.database.Column;
import org.obeonetwork.dsl.database.Constraint;
import org.obeonetwork.dsl.database.DataBase;
import org.obeonetwork.dsl.database.DatabaseFactory;
import org.obeonetwork.dsl.database.ForeignKey;
import org.obeonetwork.dsl.database.ForeignKeyElement;
import org.obeonetwork.dsl.database.Index;
import org.obeonetwork.dsl.database.IndexElement;
import org.obeonetwork.dsl.database.PrimaryKey;
import org.obeonetwork.dsl.database.Schema;
import org.obeonetwork.dsl.database.Sequence;
import org.obeonetwork.dsl.database.Table;
import org.obeonetwork.dsl.database.TableContainer;
import org.obeonetwork.dsl.database.View;
import org.obeonetwork.dsl.typeslibrary.NativeType;
import org.obeonetwork.dsl.typeslibrary.NativeTypesLibrary;
import org.obeonetwork.dsl.typeslibrary.TypeInstance;
import org.obeonetwork.dsl.typeslibrary.TypesLibraryFactory;

public class CreationUtils {

	public static DataBase createDatabase(String name) {
		DataBase database = DatabaseFactory.eINSTANCE.createDataBase();
		database.setName(name);
		return database;
	}

	public static Schema createSchema(String name) {
		Schema schema = DatabaseFactory.eINSTANCE.createSchema();
		schema.setName(name);
		return schema;
	}
	
	public static Table createTable(TableContainer owner, String name) {
		Table table = DatabaseFactory.eINSTANCE.createTable();
		table.setName(name);
		owner.getTables().add(table);
		return table;
	}
	
	public static AbstractTable createView(TableContainer owner, String name) {
		View view = DatabaseFactory.eINSTANCE.createView();
		view.setName(name);
		owner.getTables().add(view);
		return view;
	}
	
	public static Index createIndex(Table table, String name) {
		Index index = DatabaseFactory.eINSTANCE.createIndex();
		index.setName(name);
		index.setOwner(table);
		table.getIndexes().add(index);
		return index;
	}
	
	public static IndexElement createIndexElement(Index index) {
		IndexElement indexElement = DatabaseFactory.eINSTANCE.createIndexElement();
		index.getElements().add(indexElement);
		return indexElement;
	}
	
	public static PrimaryKey createPrimaryKey(Table table, String name) {
		PrimaryKey primaryKey = DatabaseFactory.eINSTANCE.createPrimaryKey();
		primaryKey.setName(name);
		primaryKey.setOwner(table);
		table.setPrimaryKey(primaryKey);
		return primaryKey;
	}
	
	public static Column createColumn(AbstractTable table, String name) {
		Column column = DatabaseFactory.eINSTANCE.createColumn();
		column.setName(name);
		column.setOwner(table);
		table.getColumns().add(column);
		return column;
	}
	
	public static ForeignKey createForeignKey(Table table) {
		ForeignKey foreignKey = DatabaseFactory.eINSTANCE.createForeignKey();
		table.getForeignKeys().add(foreignKey);
		return foreignKey;
	}
	
	public static ForeignKeyElement createForeignKeyElement(int keySequence, ForeignKey foreignKey) {
		ForeignKeyElement foreignKeyElement = DatabaseFactory.eINSTANCE.createForeignKeyElement();
		foreignKey.getElements().add(foreignKeyElement);
		return foreignKeyElement;
	}
	
	public static Constraint createConstraint(Table owner, String name) {
		Constraint constraint = DatabaseFactory.eINSTANCE.createConstraint();
		constraint.setName(name);
		constraint.setOwner(owner);
		return constraint;
	}
	
	public static Sequence createSequence(TableContainer owner, String name, int increment, int minValue, Integer maxValue, int start) {
		Sequence sequence = DatabaseFactory.eINSTANCE.createSequence();
		sequence.setName(name);
		sequence.setIncrement(increment);
		sequence.setMinValue(minValue);
		sequence.setMaxValue(maxValue);
		sequence.setStart(start);
		owner.getSequences().add(sequence);
		return sequence;
	}
	
	public static TypeInstance createTypeInstance(NativeTypesLibrary nativeTypesLibrary, String columnType, int columnSize, int decimalDigits) {
		NativeType nativeType = nativeTypesLibrary.findTypeByName(columnType);
		if (nativeType == null) {
			System.err.println("handleMetaDatasColumn : native type [" + columnType + "] not found.");
		}
		TypeInstance typeInstance = TypesLibraryFactory.eINSTANCE.createTypeInstance();
		typeInstance.setNativeType(nativeType);
		typeInstance.setLength(columnSize);
		typeInstance.setPrecision(decimalDigits);
		return typeInstance;
	}
	
}
