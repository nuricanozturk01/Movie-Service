package nuricanozturk.dev.movie.data.repository;

public enum Query
{
    SQL_MOVIE_COUNT_QUERY("select count(*) from movies"),
    SQL_MOVIE_SCENE_DATE_MONTH_QUERY("select * from movies where date_part('month', scene_date) = :mon"),
    SQL_MOVIE_SCENE_DATE_YEAR_QUERY("select * from movies where date_part('year', scene_date) = :year");

    private final String m_query;
    Query(String query)
    {
        m_query = query;
    }

    public String getQuery()
    {
        return m_query;
    }
}
