package ass.bzu;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AddQ {
    private List<QA> QAns;

    public AddQ() {
        QAns = new ArrayList<>();
        QAns.add(new QA(" What is the purpose of a constructor in Java?", "Constructors: Initializes objects, sets initial values for attributes"));
        QAns.add(new QA("Explain the difference between == and .equals() in Java", "== vs. .equals(): Compares references vs. contents/values of objects."));
        QAns.add(new QA("What is the significance of the static keyword in Java?","It is the entry point of a Java program. It is called by the Java Virtual Machine (JVM) to start the execution of the program"));
        QAns.add(new QA("Explain the concept of inheritance in object-oriented programming?", "Static Keyword: Declares variables, methods, nested classes belonging to class, shared among all instances."));
        QAns.add(new QA("What is polymorphism and how is it implemented in Java?", "Inheritance: New class inherits properties, behaviors from existing class, enables code reuse, hierarchical class structure."));
        QAns.add(new QA("How do you handle exceptions in Java?", "Polymorphism: Method behaves differently based on calling object, achieved through method overriding, overloading."));

    }

    public QA[] getRandomQuestions(int count) {
        Random rand = new Random();
        List<QA> randomQuestions = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            int randomIndex = rand.nextInt(QAns.size());
            randomQuestions.add(QAns.get(randomIndex));
            QAns.remove(randomIndex);
        }

        return randomQuestions.toArray(new QA[0]);
    }
}