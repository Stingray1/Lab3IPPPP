package com.company.Iterator;

/**
 * Created by vadim on 12/7/16.
 */
public class Iterator {
    public static void main(String[] args)
    {

        String[] skills = {"Java", "Spring", "Hybernate", "Maven"};

        javaDeveloper developer = new javaDeveloper("Vadim", skills);
        IteratorExample iterator = developer.getIterator();
        System.out.println("Developer "+developer.getName());
        System.out.println("Skills :" );
        while(iterator.hasNext())
        {
            System.out.println(iterator.next().toString()+ " ");
        }


    }
}
interface IteratorExample
{
    public boolean hasNext();
    public Object next();
}
interface Collection
{
    IteratorExample getIterator();
}

class javaDeveloper implements  Collection
{
    private String name;
     private String[] skills;

    public javaDeveloper(String name, String[] skills) {
        this.name = name;
        this.skills = skills;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getSkills() {
        return skills;
    }

    public void setSkills(String[] skills) {
        this.skills = skills;
    }

    @Override
    public IteratorExample getIterator() {
        return new SkillIterator();
    }
    private class  SkillIterator implements  IteratorExample
    {
        int index ;

        @Override
        public boolean hasNext() {
            if(index<skills.length)
            {
                return true;
            }

                return false;

        }

        @Override
        public Object next() {

            return skills[index++];
        }
    }
}
