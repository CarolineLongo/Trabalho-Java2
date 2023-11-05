// Classe Originator
class TextEditor {
    private String text;

    public TextEditor() {
        this.text = "";
    }

    public void addText(String newText) {
        this.text += newText;
    }

    public Memento save() {
        return new Memento(text);
    }

    public void restore(Memento memento) {
        this.text = memento.getText();
    }

    public String getText() {
        return text;
    }
}

// Classe Memento
class Memento {
    private String text;

    public Memento(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}

// Classe Caretaker
class History {
    private List<Memento> mementos = new ArrayList<>();

    public void save(Memento memento) {
        mementos.add(memento);
    }

    public Memento get(int index) {
        return mementos.get(index);
    }
}
