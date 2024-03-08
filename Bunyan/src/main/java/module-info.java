module person.bunyan {
 requires javafx.controls;
 requires org.hibernate.orm.core; 
 requires java.naming;
 requires java.persistence;
 requires java.sql;
 opens person.bunyan to org.hibernate.orm.core;

    exports person.bunyan;
}
