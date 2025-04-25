package Recipe.classes;

abstract public class User
{
    protected String name;
    protected String password;
    protected int numRecipes;
    protected List<Recipe> createdRecipes;

    public User(String name, int numRecipes, List<Recipe> createdRecipes)
    {
        this.name = name;
        this.numRecipes = numRecipes;
        this.createdRecipes = createdRecipes;
    }



    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public int getNumRecipes()
    {
        return numRecipes;
    }

    public void setNumRecipes(int numRecipes)
    {
        this.numRecipes = numRecipes;
    }

    public List<Recipe> getCreatedRecipes()
    {
        return createdRecipes;
    }

    public void setCreatedRecipes(List<Recipe> createdRecipes)
    {
        this.createdRecipes = createdRecipes;
    }
}
