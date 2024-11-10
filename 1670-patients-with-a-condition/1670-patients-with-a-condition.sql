-- Select patients whose condition contains 'DIAB1'
SELECT patient_id, patient_name, conditions 
FROM Patients 
WHERE conditions LIKE 'DIAB1%' or conditions like '% DIAB1%';
