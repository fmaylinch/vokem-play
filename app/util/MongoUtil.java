package util;

import com.mongodb.DBCursor;
import com.mongodb.DBObject;

import java.util.ArrayList;
import java.util.List;

public class MongoUtil
{
    /**
     * Converts a {@link DBCursor} to a {@link List} by iterating
     * the {@link DBCursor} and converting each {@link DBObject}
     * to an object of type {@link T} using the 'converter' {@link Function}.
     */
    public static <T> List<T> convert(DBCursor cursor, Function<DBObject, T> converter)
    {
        final List<T> result = new ArrayList<>();

        while (cursor.hasNext())
        {
            final DBObject object = cursor.next();
            result.add(converter.apply(object));
        }

        return result;
    }

}
