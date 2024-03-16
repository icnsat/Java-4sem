package sem_4.pract_8.Memento;

public class TestMemento {
    public static void main(String[] args) {
        ProjectMemento project = new ProjectMemento();
        Repos repos = new Repos();

        System.out.println("Создан новый проект. Версия 1.\n");
        project.setVersion("1.0");
        System.out.println(project);

        System.out.println("Сохранение версии в репозитории\n");
        repos.setSave(project.save());

        System.out.println("Изменение проекта. Версия 2.\n");
        project.setVersion("2.0");
        System.out.println(project);

        System.out.println("Возврат предыдущей версии проекта.\n");
        project.load(repos.getSave());
        System.out.println(project);
    }
}
