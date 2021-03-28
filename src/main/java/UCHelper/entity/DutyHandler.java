/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UCHelper.entity;

import UCHelper.adt.Set;
import UCHelper.adt.SetInterface;
import java.util.Objects;

/**
 *
 * @author cc
 */
public class DutyHandler {
   
   public SetInterface<Lecturer> dutyLec = new Set<Lecturer>();
   public SetInterface<Student> dutyStud = new Set<Student>();

    public SetInterface<Lecturer> getDutyLec() {
        return dutyLec;
    }

    public void setDutyLec(SetInterface<Lecturer> dutyLec) {
        this.dutyLec = dutyLec;
    }

    public SetInterface<Student> getDutyStud() {
        return dutyStud;
    }

   
    public void setDutyStud(SetInterface<Student> dutyStud) {
        this.dutyStud = dutyStud;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.dutyLec);
        hash = 47 * hash + Objects.hashCode(this.dutyStud);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final DutyHandler other = (DutyHandler) obj;
        if (!Objects.equals(this.dutyLec, other.dutyLec)) {
            return false;
        }
        if (!Objects.equals(this.dutyStud, other.dutyStud)) {
            return false;
        }
        return true;
    }
   

   
    

   

   
    
   
    
   
    
    
    
    
}
