package pl.strefakursu.hibernatedemo.entity;

import javax.persistence.*;

@Entity // określa, że dana klasa jest encja
@Table(name="employee")
public class Employee {

    /*GenerationType.Auto - automatyczne określenie sposobu generowania
    * Sposób określany w oparciu o zastosowany dialekt SQL
    * Domyślna wartość
    *  */

    /*GenerationType.Identity - baza danych sama określa i
     * przypisuje klucz podstawowy
     * autoikrementowana kolumna klucza głównego
     *  */
    /*GenerationType.Sequence - baza danych generuje klucze
    w oparciu o sekwencje (sekwencja wywoływana przed każdą instrukcją insert)
     *  */
    /*GenerationType.Table - hibernate korzysta z dodatkowej tabeli w schemacie
    baz danych
     *  */
    // SequenceGenerator - można stworzyć własną strategie

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_employee")
    private Integer idEmployee;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="salary")
    private Integer salary;

    public Integer getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(Integer idEmployee) {
        this.idEmployee = idEmployee;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }


    @Override
    public String toString() {
        return "pl.strefakursu.hibernatedemo.Employee{" +
                "idEmployee=" + idEmployee +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", salary=" + salary +
                '}';
    }

}


// Hibernate Query Language
// W pełni zorientowany obiektowo
// podobny do SQL