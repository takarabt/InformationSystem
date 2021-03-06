-- ==============================================================
--  Table : T1                                    
-- ==============================================================
ALTER TABLE T1 MODIFY C3 INT NOT NULL;

ALTER TABLE T1 ADD T5_ID INT NOT NULL;
-- ==============================================================
--  Table : T4                                    
-- ==============================================================
-- ==============================================================
--  Table : T3                                    
-- ==============================================================
-- ==============================================================
--  Table : T2                                    
-- ==============================================================
-- ==============================================================
--  Table : T1_1                                    
-- ==============================================================
-- ==============================================================
--  Table : T1_4                                    
-- ==============================================================
ALTER TABLE T1_4 MODIFY C1 DECIMAL(12, 10) NOT NULL;
-- ==============================================================
--  Table : T1_1                                    
-- ==============================================================
-- ==============================================================
--  Table : T1_1                                    
-- ==============================================================
-- ==============================================================
--  Table : T1_1                                    
-- ==============================================================
-- ==============================================================
--  Table : T7_7                                    
-- ==============================================================
-- ==============================================================
--  Table : T7_6                                    
-- ==============================================================
-- ==============================================================
--  Table : T7_5                                    
-- ==============================================================
-- ==============================================================
--  Table : T7_4                                    
-- ==============================================================
-- ==============================================================
--  Table : T7_3                                    
-- ==============================================================
-- ==============================================================
--  Table : T7_2                                    
-- ==============================================================
-- ==============================================================
--  Table : T7_1                                    
-- ==============================================================
-- ==============================================================
--  Table : T1_1                                    
-- ==============================================================
-- ==============================================================
--  Table : ALTERTABLE                                    
-- ==============================================================
ALTER TABLE ALTERTABLE MODIFY UpdateColumnChangedType DATE NOT NULL;

ALTER TABLE ALTERTABLERENAMED ADD AddColumn2 DATE NOT NULL;

ALTER TABLE ALTERTABLE DROP COLUMN RemoveColumn2;

COMMENT ON TABLE AlterTable IS 'Initial comment
';
	
ALTER TABLE ALTERTABLE RENAME TO ALTERTABLERENAMED;

COMMENT ON COLUMN ALTERTABLERENAMED.UpdateColumn2Renamed IS 'Modified comment';

ALTER TABLE ALTERTABLERENAMED RENAME COLUMN UpdateColumn2 TO UpdateColumn2Renamed;
