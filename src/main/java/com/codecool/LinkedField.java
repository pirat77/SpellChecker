public class LinkedField {
    private class Field{
        private Field nextField;
        private String value;

        Field(String value){
            this.value = value;
            nextField = null;
        }

        public String getValue() {
            return value;
        }

        void setNext(Field nextField){
            this.nextField = nextField;
        }

        Field getNextField(){
            return nextField;
        }
    }

    Field firstField;

    LinkedField(){
        firstField = null;
    }

    void add(String s){
        if (this.isEmpty()) {
            firstField = new Field(s);
        } else {
            Field currentField = firstField;
            while (currentField.getNextField() != null){
                if (currentField.getValue().equals(s)) return;
                currentField.setNext(new Field(s));
            }

        }
    }

    boolean isEmpty(){
        return firstField == null;
    }

    boolean contains(String s){
        Field field = firstField;
        while (field != null) {
            if (field.value.equals(s)) return true;
            field = field.getNextField();
        }
        return false;
    }

    void remove(String s){
        if (firstField.equals(s)){
            firstField = firstField.getNextField();
            return;
        }

        Field field = firstField;

        while (field.nextField != null){
            if (field.nextField.value.equals(s)){
                field.setNext(field.getNextField().getNextField());
                return;
            }
            field = field.getNextField();
        }
    }
}
