![Logo](mwm-2-room/room-2.png )

#### <span style="text-transform: none">Android Arch - Room</span>

<span style="color:gray; font-size:0.6em;">android.arch.persistence.room</span>
<br>
<span style="color:gray; font-size:0.5em;">13-10-2017</span>

---

### <span style="color: #00B8D4; text-transform: none">Room</span> <span style="text-transform: none">goal</span>
<br>

* No boilerplate: SQL queries / Java data objects
* Compile-time verification

---

### <span style="color: #00B8D4; text-transform: none">Room</span> <span style="text-transform: none">components</span>
<br>

* Entity
* Database
* Data Access Objects

---

### <span style="color: #00B8D4; text-transform: none">Entity</span>
<br>

```kotlin
@Entity(tableName = "example")
class Example(

    @PrimaryKey
    val id: String,
    
    @ColumnInfo(name = "name")
    val name: String,
    
    val timestamp: Long,
    
    @Ignore
    val picture: Bitmap)
```

<span style="color:gray; font-size:0.6em;">Example.kt</span>

---

### <span style="color: #00B8D4; text-transform: none">Entity</span> <span style="text-transform: none">nested</span>
<br>

```kotlin
class Nested (
    val id: String,
    
    @ColumnInfo(name = "nested_name")
    val name: String)

@Entity(tableName = "example")
class Example(
    @PrimaryKey
    val id: String,  
                          
    @Embedded
    val nested: Nested)
```

<span style="color:gray; font-size:0.6em;">Example.kt</span>
<br/>
<span style="color:gray; font-size:0.6em;">Embedded fields can include embedded fields.</span>

---

### <span style="color: #00B8D4; text-transform: none">Database</span>
<br>

```kotlin
@Database(entities = arrayOf(Example::class), version = 1)
@TypeConverters(ConverterListString::class) // Optional
abstract class ExampleDatabase : RoomDatabase() {

    abstract fun exampleDao(): ExampleDao
}
```

<span style="color:gray; font-size:0.6em;">ExampleDatabase.kt</span>

---

### <span style="color: #00B8D4; text-transform: none">Database</span> <span style="text-transform: none">converter</span>
<br>

```kotlin
class ConverterListString {

    companion object {
        val gson = Gson()
        val listType = object : TypeToken<List<String>>() {}.type
    }

    @TypeConverter
    fun fromString(value: String): List<String>? {
        return gson.fromJson(value, listType)
    }

    @TypeConverter
    fun fromArrayList(list: List<String>): String {
        return gson.toJson(list)
    }
}
```

<span style="color:gray; font-size:0.6em;">ConverterListString.kt</span>

---

### <span style="color: #00B8D4; text-transform: none">DAO</span>
<br>

```kotlin
@Dao
interface ExampleDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun put(example: Example)
    
    @Insert
    fun putAll(vararg examples: Example)

    @Query("SELECT * FROM example ORDER BY name DESC")
    fun get(): List<Example>
    
    @Query("SELECT * FROM example WHERE timestamp > :minTimestamp")
    fun get(minTimestamp: Long): List<Example>
    
    @Query("SELECT * FROM example WHERE is IN (:ids)")
    fun get(ids: List<String>): List<Example>
    
    @Update // Matches against the primary 
    fun updateAll(vararg examples: Example)

    @Delete
    fun delete(example: Example)

    @Query("DELETE FROM example")
    fun clearAll()
}
```

<span style="color:gray; font-size:0.6em;">ExampleDao.kt</span>

---

### <span style="color: #00B8D4; text-transform: none">Create</span> <span style="text-transform: none">Database / Dao</span>
<br>

```kotlin
fun provideExampleDAO(
    application: MainApplication): ExampleDao {
        val exampleDatabase = Room.databaseBuilder(
            application,
            ExampleDatabase::class.java,
            "database_name.db").build()
        return exampleDatabase.exampleDao()
}
```

<span style="color:gray; font-size:0.6em;">ExampleModule.kt</span>

---

### <span style="text-transform: none">Setup</span>
<br>
* google() or maven { url 'https://maven.google.com' }
* android.arch.persistence.room compile + annotProc/kapt

---

### <span style="color: #00B8D4; text-transform: none">And so much more</span>
<br>
* RxJava
* Live Data
* ForeignKey

---

### Demo

<span style="color:gray; font-size:0.5em;">Source: developer.android.com/topic/libraries/architecture/room.html</span>
</br>
<span style="color:gray; font-size:0.5em;">Presentation: github.com/Mercandj/tracker-android/blob/master/config/room-presentation/PITCHME.pdf</span>
