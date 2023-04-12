package nuricanozturk.dev.movie.data.repository.jdbc;

public enum Query
{
    SQL_MOVIE_COUNT_QUERY("select count(*) from movies"),
    SQL_MOVIE_SCENE_DATE_MONTH_QUERY("select * from movies where date_part('month', scene_date) = :mon"),
    SQL_MOVIE_SCENE_DATE_MONTH_YEAR_QUERY("select * from movies where date_part('month', scene_date) = :mon and date_part('year', scene_date) = :year"),
    SQL_MOVIE_SCENE_DATE_BETWEEN_YEAR_QUERY("select * from movies where date_part('year', scene_date) between :b and :e"),
    SQL_MOVIE_SCENE_DATE_YEAR_QUERY("select * from movies where date_part('year', scene_date) = :year"),
    SQL_MOVIE_BY_DIRECTOR_ID_QUERY("""
            select * from movies as m, movies_to_director as md where m.movie_id = md.movie_id and md.director_id = :id
            """),
    SQL_DIRECTOR_BY_MOVIE_ID_QUERY("select * from get_directors_by_movie_id(:movieId)");

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
