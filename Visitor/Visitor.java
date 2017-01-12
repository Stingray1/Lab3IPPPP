package com.company.Visitor;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

/**
 * Created by vadim on 12/7/16.
 */
public class Visitor {
    public static void main(String[] args)
    {
            Project project = new Project();
            Developer junior = new juniorDeveloper();
            Developer senior = new seniorDeveloper();

            System.out.println ("Junior in Action");
            project.bewriteen(junior);
            System.out.println("\n======================\n");
            System.out.println ("Senior in Action");
            project.bewriteen(senior);

    }
}

interface ProjectElement
{
    public void bewriteen(Developer developer);
}

class ProjectClass implements  ProjectElement
{
    @Override
    public void bewriteen(Developer developer) {
        developer.create(this);
    }
}

class  Database implements ProjectElement
{
    @Override
    public void bewriteen(Developer developer) {
        developer.create(this);
    }
}

class Test implements ProjectElement
{
    @Override
    public void bewriteen(Developer developer) {
        developer.create(this);
    }
}

interface Developer
{
    public void create (ProjectClass projectClass);
    public void create(Database database);
    public void create(Test test);
}

class Project implements ProjectElement
{
    ProjectElement[] projectElements;

    public Project() {
        this.projectElements = new ProjectElement[]{
                new ProjectClass(),
                new Database(),
                new Test()
        };
    }
    @Override
    public void bewriteen(Developer developer) {
        for(ProjectElement projectElement:projectElements)
        {
            projectElement.bewriteen(developer);
        }

    }
}
class juniorDeveloper implements  Developer
{
    @Override
    public void create(ProjectClass projectClass) {
        System.out.println ("Write poor class");

    }

    @Override
    public void create(Database database) {
        System.out.println ("Drop database");
    }

    @Override
    public void create(Test test) {
        System.out.println ("not reliable Test");
    }
}
class seniorDeveloper implements  Developer
{
    @Override
    public void create(ProjectClass projectClass) {
        System.out.println ("Rewrite class after junior");

    }

    @Override
    public void create(Database database) {
        System.out.println ("Fixing database");
    }

    @Override
    public void create(Test test) {
        System.out.println ("Creating Reliable Test");
    }
}