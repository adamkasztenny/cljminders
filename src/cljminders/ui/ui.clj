(ns cljminders.ui.ui
  (:require [cljminders.db.operations :as operations])
  (:gen-class))

(defn getReminderFieldsFromInput []
	(println "Description of reminder: ")
	(def description (read-line))
	(println "Time (in valid format, e.g. 2016-01-01 17:05): ")
	(def time (read-line))
	{:description description :time time}
)

(defn promptForReminderId [operation]
	(println "Which reminder do you want to" operation "(enter the number)?" )
	(read-line)
)

(defn createNewReminder [] 
	(def descriptionAndTime (getReminderFieldsFromInput))
	(def id (count (operations/selectReminders)))
	(def reminder (merge descriptionAndTime {:id id}))
	(operations/createReminder reminder)
)

(defn showReminders [] 
	(println "\n#   |") 
	(doseq [reminder (operations/selectReminders)] (operations/printReminder reminder))
	true
)

(defn updateReminder [] 
	(def id (promptForReminderId "update"))
	(def descriptionAndTime (getReminderFieldsFromInput))
	(def reminder (merge descriptionAndTime {:id id}))
	(operations/updateReminder reminder id)
)

(defn deleteReminder [] 
	(def id (promptForReminderId "delete"))
	(operations/deleteReminder id)
)

(defn runOperationBasedOnInput [input] 
	(case input
		"1" (createNewReminder)
		"2" (showReminders)  
		"3" (updateReminder) 
		"4" (deleteReminder) 
		false
	)
)

(defn prompt []
	(loop []
		(println "\n1. Create new reminder")
		(println "2. Show all reminders")
		(println "3. Update existing reminder")
		(println "4. Delete reminder")
		(println "5. Exit")
		(if (runOperationBasedOnInput (read-line)) (recur))
	)
)
