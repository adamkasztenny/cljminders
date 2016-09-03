(ns cljminders.ui.ui
  (:require [cljminders.db.operations :as operations])
  (:gen-class))

(defn printReminder [reminder] 
	(def id (get reminder :id))
	(def description (get reminder :description))
	(def time (get reminder :time))
	(println id " |" time description)
)

(defn getReminderFieldsFromInput []
	(println "Description of reminder: ")
	(def description (read-line))
	(println "Time (in valid format, e.g. 2016-01-01 17:05): ")
	(def time (read-line))
	{:description description :time time}
)

(defn createNewReminder [] 
	(def descriptionAndTime (getReminderFieldsFromInput))
	(def id (count (operations/selectReminders)))
	(def reminder (merge descriptionAndTime {:id id}))
	(operations/createReminder reminder)
)

(defn showReminders [] 
	(println "\n#  |") 
	(doseq [reminder (operations/selectReminders)] (printReminder reminder))
	(println "\n")
)

(defn runOperationBasedOnInput [input] 
	(case input
		"1" (createNewReminder)
		"2" (showReminders)  
		"3" (println "update") 
		"4" (println "delete") 
		false
	)
)

(defn prompt []
	(loop []
		(println "\nWhat would you like to do?")
		(println "1. Create new reminder")
		(println "2. Show all reminders")
		(println "3. Update existing reminder")
		(println "4. Delete reminder")
		(println "5. Exit")
		(if (runOperationBasedOnInput (read-line)) (recur))
	)
)
