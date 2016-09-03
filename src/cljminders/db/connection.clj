; Thanks to https://github.com/korma/Korma
(ns cljminders.db.connection)
(use 'korma.db)
(use 'korma.core)

(defdb db (sqlite3 {:db ".cljminders.db"}))

(defentity reminders
    (pk :id) 
    (table :reminders)
    (database db)
    (entity-fields :description :time)
)

(def createReminders (str "
                          CREATE TABLE IF NOT EXISTS reminders
                          ( 
                            id int,
                            description text,
                            time timestamp
                          );
                          "))

(exec-raw createReminders)
