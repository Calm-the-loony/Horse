import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StableGUI extends JFrame {

    private Stable stable;

    public StableGUI() {
        super("Конюшня");

        stable = new Stable();

        JButton addHorseButton = new JButton("Добавить лошадь");
        JButton addEmployeeButton = new JButton("Добавить сотрудника");
        JButton showInfoButton = new JButton("Показать информацию");

        // Цветовые эффекты
        addHorseButton.setBackground(new Color(255, 255, 255));
        addEmployeeButton.setBackground(new Color(245, 200, 255));
        showInfoButton.setBackground(new Color(163, 245, 144));

        Font buttonFont = new Font("Arial", Font.BOLD, 14);
        addHorseButton.setFont(buttonFont);
        addEmployeeButton.setFont(buttonFont);
        showInfoButton.setFont(buttonFont);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        panel.add(addHorseButton);
        panel.add(addEmployeeButton);
        panel.add(showInfoButton);

        add(panel, BorderLayout.CENTER);

        addHorseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String horseName = JOptionPane.showInputDialog("Введите имя лошади:");
                int horseAge = Integer.parseInt(JOptionPane.showInputDialog("Введите возраст лошади:"));
                Horse horse = new Horse(horseName, horseAge);
                stable.addHorse(horse);
                JOptionPane.showMessageDialog(null, "Лошадь добавлена успешно!");
            }
        });

        addEmployeeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String employeeName = JOptionPane.showInputDialog("Введите имя сотрудника:");
                int employeeID = Integer.parseInt(JOptionPane.showInputDialog("Введите ID сотрудника:"));
                Employee employee = new Employee(employeeName, employeeID);
                stable.addEmployee(employee);
                JOptionPane.showMessageDialog(null, "Сотрудник добавлен успешно!");
            }
        });

        showInfoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StringBuilder info = new StringBuilder();
                info.append("Лошади в конюшне:\n");
                for (Animal horse : stable.getHorses()) {
                    info.append("Имя: ").append(horse.getName()).append(", Возраст: ").append(horse.getAge()).append("\n");
                }

                info.append("\nСотрудники в конюшне:\n");
                for (Employee employee : stable.getEmployees()) {
                    info.append("Имя: ").append(employee.getName()).append(", ID: ").append(employee.getEmployeeID()).append("\n");
                }

                JTextArea textArea = new JTextArea(info.toString());
                textArea.setEditable(false);

                JScrollPane scrollPane = new JScrollPane(textArea);
                JOptionPane.showMessageDialog(null, scrollPane, "Информация о конюшне", JOptionPane.PLAIN_MESSAGE);
            }
        });


        getContentPane().setBackground(new Color(218, 85, 255)); // Фон окна

        setSize(900, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

        // Additional buttons
        JButton callVetButton = new JButton("Вызвать ветеринара");
        JButton participateInCompetitionButton = new JButton("Участвовать в соревнованиях");
        JButton goForAWalkButton = new JButton("Выход на прогулку");
        JButton goOnTrailButton = new JButton("Поход на лошадях");

        callVetButton.setBackground(new Color(252, 227, 121));
        participateInCompetitionButton.setBackground(new Color(255, 189, 163));
        goForAWalkButton.setBackground(new Color(140, 215, 255));
        goOnTrailButton.setBackground(new Color(207, 150, 255));

        callVetButton.setFont(buttonFont);
        participateInCompetitionButton.setFont(buttonFont);
        goForAWalkButton.setFont(buttonFont);
        goOnTrailButton.setFont(buttonFont);

        panel.add(callVetButton);
        panel.add(participateInCompetitionButton);
        panel.add(goForAWalkButton);
        panel.add(goOnTrailButton);

        callVetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String vetName = JOptionPane.showInputDialog("Введите имя ветеринара:");
                int vetID = Integer.parseInt(JOptionPane.showInputDialog("Введите ID ветеринара:"));
                Veterinarian vet = new Veterinarian(vetName, vetID);
                Horse selectedHorse = selectHorseDialog();
                if (selectedHorse != null) {
                    selectedHorse.callVeterinarian(vet);
                    JOptionPane.showMessageDialog(null, "Ветеринар вызван для лошади " + selectedHorse.getName());
                }
            }
        });

        participateInCompetitionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Horse selectedHorse = selectHorseDialog();
                if (selectedHorse != null) {
                    HorseRidingCompetition competition = new HorseRidingCompetition("Лошадиные гонки");
                    selectedHorse.participateInCompetition(competition);
                    competition.conductCompetition();
                }
            }
        });

        goForAWalkButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Horse selectedHorse = selectHorseDialog();
                if (selectedHorse != null) {
                    selectedHorse.goForAWalk();
                    JOptionPane.showMessageDialog(null, "Лошадь " + selectedHorse.getName() + " вышла на прогулку.");
                }
            }
        });

        goOnTrailButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Horse selectedHorse = selectHorseDialog();
                Horse companionHorse = selectHorseDialog();
                if (selectedHorse != null && companionHorse != null) {
                    selectedHorse.goOnTrail(companionHorse);
                    JOptionPane.showMessageDialog(null, "Лошади " + selectedHorse.getName() +
                            " и " + companionHorse.getName() + " отправились в поход.");
                }
            }
        });
    }

    private Horse selectHorseDialog() {
        String[] horseNames = stable.getHorses().stream().map(Animal::getName).toArray(String[]::new);
        String selectedHorseName = (String) JOptionPane.showInputDialog(
                null,
                "Выберите лошадь:",
                "Выбор лошади",
                JOptionPane.QUESTION_MESSAGE,
                null,
                horseNames,
                horseNames[0]);

        if (selectedHorseName != null) {
            return (Horse) stable.getHorses().stream()
                    .filter(horse -> horse.getName().equals(selectedHorseName))
                    .findFirst()
                    .orElse(null);
        }
        return null;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new StableGUI();
            }
        });
    }
}
