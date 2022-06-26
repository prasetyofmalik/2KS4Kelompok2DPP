package mform.form;

import java.util.ArrayList;
import java.util.List;

public abstract class Form implements Validation {
    List<String> errorMessages = new ArrayList<String>();
    
    public abstract boolean save();
    public abstract void headerForm();
    public abstract void print();
    public abstract void reset();

    public List<String> getErrorMessages() {
        return this.errorMessages;
    }

    public void addErrorMesssages(String message) {
        this.errorMessages.add(message);
    }
    
}
