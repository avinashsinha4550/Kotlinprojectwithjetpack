package com.compare.show

import android.annotation.SuppressLint
import android.app.Person
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteException
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import com.compare.show.screens.MobileListModel
import com.sqlitekotline.ProductAttributes

class DatabaseHandler(context: Context) : SQLiteOpenHelper(
    context,
    DATABASE_NAME,
    null,
    DATABASE_VERSION
) {
    companion object {
        private val DATABASE_VERSION = 4
        private val DATABASE_NAME = "compareshow"
        private val TABLE_CONTACTS = "product"
        private val KEY_ID = "id"
        private var KEY_Name = "name"
        private var KEY_Descripations = "descripations"
        private var KEY_FrantImage = "frantimage"
        private var KEY_BackImage = "backimage"
        private val KEY_RAMTitle = "ramtitle"
        private val KEY_RAMDescription = "ramdescription"
        private val KEY_RAMEG = "rameg"
        private val KEY_DisplayTitle = "displaytitle"
        private val KEY_DisplayDescription = "displaydescription"
        private val KEY_Mobile_Proccesor = "mobilepro"
        private val KEY_MainCameraTitle = "maincameratitle"
        private val KEY_MainCameraDescription = "maincameradescription"
        private val KEY_FrantCameraTitle = "camrafranttitle"
        private val KEY_FrantCameraDescription = "camrafrantdescription"
        private val KEY_GamingGpuTitle = "gaminggputitle"
        private val KEY_GamingGpuDescription = "gaminggpudescription"
        private val KEY_NetworkSpeedTitle = "networkspeedgaminggputitle"
        private val KEY_NetworkSpeedDescription = "networkspeeddescription"
        private val KEY_BodyStorageTitle = "bodystoretitle"
        private val KEY_BodyStorageDescription = "bodystoredescription"
        private val KEY_OperatingSystemTitle = "operatingsystemtitle"
        private val KEY_OperatingSystemDescription = "operatingsystemdescription"
        private val KEY_NetworkFrequencyTitle = "networkfrequencytitle"
        private val KEY_NetworkFrequencyDescription = "networkfrequencydescription"
        private val KEY_CompanyAccessoryTitle = "companyaccessorytitle"
        private val KEY_CompanyAccessoryDescription = "companyaccessorydescription"
        private val KEY_ConclusionTitle = "conclusiontitle"
        private val KEY_ConclusionDescription = "conclusiondescription"
        private val KEY_Water_proff = "waterproff"
        private val KEY_SSD_space = "sdd"
        private val KEY_Price = "price"
        private var KEY_Check = "markcheck"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        // TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        //creating table with fields
        Log.e("onCreate", "onCreate")
        /* val CREATE_TABLE = ("CREATE TABLE " + TABLE_CONTACTS.toString() + "("
                 + KEY_Name.toString() + "INTEGER PRIMARY KEY ,"
                 + KEY_Descripations.toString() + "VARCHAR,"
                 + KEY_FrantImage.toString() + "VARCHAR" + ")")
         db!!.execSQL(CREATE_TABLE)*/
        val CREATE_CONTACTS_TABLE = ("CREATE TABLE " + TABLE_CONTACTS + "("
                + KEY_ID.toString() + "  INTEGER ,"
                + KEY_Name.toString() + "  VARCHAR,"
                + KEY_Descripations.toString() + "  VARCHAR,"
                + KEY_FrantImage.toString() + "  VARCHAR,"
                + KEY_BackImage.toString() + "  VARCHAR,"
                + KEY_RAMTitle.toString() + "  VARCHAR,"
                + KEY_RAMDescription.toString() + "  VARCHAR,"
                + KEY_RAMEG.toString() + "  VARCHAR ,"
                + KEY_Mobile_Proccesor + " VARCHAR ,"
                + KEY_DisplayTitle.toString() + " VARCHAR ,"
                + KEY_DisplayDescription.toString() + " VARCHAR ,"
                + KEY_MainCameraTitle.toString() + " VARCHAR,"
                + KEY_MainCameraDescription.toString() + " VARCHAR,"
                + KEY_FrantCameraTitle.toString() + " VARCHAR,"
                + KEY_FrantCameraDescription.toString() + " VARCHAR,"
                + KEY_GamingGpuTitle.toString() + " VARCHAR,"
                + KEY_GamingGpuDescription.toString() + " VARCHAR,"
                + KEY_NetworkSpeedTitle.toString() + " VARCHAR,"
                + KEY_NetworkSpeedDescription.toString() + " VARCHAR,"
                + KEY_BodyStorageTitle.toString() + "  VARCHAR,"
                + KEY_BodyStorageDescription.toString() + "  VARCHAR,"
                + KEY_OperatingSystemTitle.toString() + "  VARCHAR,"
                + KEY_OperatingSystemDescription.toString() + "  VARCHAR,"
                + KEY_NetworkFrequencyTitle.toString() + "  VARCHAR,"
                + KEY_NetworkFrequencyDescription.toString() + "  VARCHAR,"
                + KEY_CompanyAccessoryTitle.toString() + "  VARCHAR,"
                + KEY_CompanyAccessoryDescription.toString() + "  VARCHAR,"
                + KEY_ConclusionTitle.toString() + "  VARCHAR,"
                + KEY_ConclusionDescription.toString() + "  VARCHAR,"
                + KEY_Water_proff.toString() + "  VARCHAR,"
                + KEY_SSD_space.toString() + "  VARCHAR,"
                + KEY_Check.toString() + "  VARCHAR,"
                + KEY_Price.toString() + "  VARCHAR" + ")")
        db!!.execSQL(CREATE_CONTACTS_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        //  TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        db!!.execSQL("DROP TABLE IF EXISTS " + TABLE_CONTACTS)
        onCreate(db)
    }

    //method to insert data
    fun addProduct(pro: ProductAttributes): Long {
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(KEY_ID, pro.id)
        contentValues.put(KEY_Name, pro.name)
        contentValues.put(KEY_Descripations, pro.descripations)
        contentValues.put(KEY_FrantImage, pro.frantImage)
        contentValues.put(KEY_BackImage, pro.backImage)
        contentValues.put(KEY_RAMTitle, pro.ramTitle)
        contentValues.put(KEY_RAMDescription, pro.ramDetails)
        contentValues.put(KEY_RAMEG, pro.ramEg)
        contentValues.put(KEY_DisplayTitle, pro.displayTitle)
        contentValues.put(KEY_DisplayDescription, pro.displayDiscription)
        contentValues.put(KEY_MainCameraTitle, pro.mainCameraTitle)
        contentValues.put(KEY_MainCameraDescription, pro.mainCameraDiscription)
        contentValues.put(KEY_FrantCameraTitle, pro.frontCameraTitle)
        contentValues.put(KEY_FrantCameraDescription, pro.frontCameraDiscription)
        contentValues.put(KEY_GamingGpuTitle, pro.gamingGpuTitle)
        contentValues.put(KEY_GamingGpuDescription, pro.gamingGpuDiscription)
        contentValues.put(KEY_NetworkSpeedTitle, pro.networkSpeedTitle)
        contentValues.put(KEY_NetworkSpeedDescription, pro.networkSpeedDiscription)
        contentValues.put(KEY_BodyStorageTitle, pro.bodyStroageTitle)
        contentValues.put(KEY_BodyStorageDescription, pro.bodyStroageDiscription)
        contentValues.put(KEY_OperatingSystemTitle, pro.operatingSystemTitle)
        contentValues.put(KEY_OperatingSystemDescription, pro.operatingSystemDiscription)
        contentValues.put(KEY_NetworkFrequencyTitle, pro.networkFrequencyTitle)
        contentValues.put(KEY_NetworkFrequencyDescription, pro.networkFrequencyDiscription)
        contentValues.put(KEY_CompanyAccessoryTitle, pro.companyAccessoryTitle)
        contentValues.put(KEY_CompanyAccessoryDescription, pro.companyAccessoryDiscription)
        contentValues.put(KEY_ConclusionTitle, pro.conclusionTitle)
        contentValues.put(KEY_ConclusionDescription, pro.conclusionDiscription)
        contentValues.put(KEY_Mobile_Proccesor, pro.proccesor)
        contentValues.put(KEY_Water_proff, pro.water_proff)
        contentValues.put(KEY_SSD_space, pro.ssd_space)
        contentValues.put(KEY_Price, pro.price)
         contentValues.put(KEY_Check, pro.check)
        Log.e("Contentvalues--", "" + contentValues.toString())
        // Inserting Row
        val success = db.insert(TABLE_CONTACTS, null, contentValues)
        //2nd argument is String containing nullColumnHack
        db.close() // Closing database connection
        return success
    }

    //method to read data
    @SuppressLint("Range")
//    fun viewProductList(): ArrayList<ProductAttributes> {
//        val prolist: ArrayList<ProductAttributes> = ArrayList<ProductAttributes>()
    fun getMobileData(): MutableList<ProductAttributes> {
        val prolist = mutableListOf<ProductAttributes>()
        val selectQuery = "SELECT  * FROM $TABLE_CONTACTS"
        val db = this.readableDatabase
        var cursor: Cursor? = null
        try {
            cursor = db.rawQuery(selectQuery, null)
        } catch (e: SQLiteException) {
            db.execSQL(selectQuery)
            return ArrayList()
        }
        var proId: Int
        var proName: String
        var proDescripations: String
        var proFrantImage: String
        var proBackImage: String
        var proRamTitle: String
        var proRamDescription: String
        var proRamEG: String
        var proDisplayTitle: String
        var proDisplayDescription: String
        var proProccesor: String
        var proMainCameraTitle: String
        var proMainCameraDescription: String
        var proFrontCameraTitle: String
        var proFrontCameraDescrtion: String
        var proGamingGpuTitle: String
        var proGamingGpuDescrtion: String
        var proNetworkSpeedTitle: String
        var proNetworkSpeedDescrtion: String
        var proBodyStorageTitle: String
        var proBodyStorageDescrtion: String
        var proOperatingSystemTitle: String
        var proOperatingSystemDescrtion: String
        var proNetworkFrequencyTitle: String
        var proNetworkFrequencyDescrtion: String
        var proCompanyAccessoryTitle: String
        var proCompanyAccessoryDescrtion: String
        var proConclusionTitle: String
        var proConclusionDescrtion: String
        var proWater_proff: String
        var proSSD_space: String
        var proPrice: String
        var proCheck: Boolean
        if (cursor.moveToFirst()) {
            do {
                proId = cursor.getInt(cursor.getColumnIndex(KEY_ID))
                proName = cursor.getString(cursor.getColumnIndex(KEY_Name))
                proDescripations = cursor.getString(cursor.getColumnIndex(KEY_Descripations))
                proFrantImage = cursor.getString(cursor.getColumnIndex(KEY_FrantImage))
                proBackImage = cursor.getString(cursor.getColumnIndex(KEY_BackImage))
                proRamTitle = cursor.getString(cursor.getColumnIndex(KEY_RAMTitle))
                proRamDescription = cursor.getString(cursor.getColumnIndex(KEY_Descripations))
                proRamEG = cursor.getString(cursor.getColumnIndex(KEY_RAMEG))
                proDisplayTitle = cursor.getString(cursor.getColumnIndex(KEY_DisplayTitle))
                proDisplayDescription = cursor.getString(cursor.getColumnIndex(KEY_DisplayDescription))
                proProccesor = cursor.getString(cursor.getColumnIndex(KEY_Mobile_Proccesor))
                proMainCameraTitle = cursor.getString(cursor.getColumnIndex(KEY_MainCameraTitle))
                proMainCameraDescription = cursor.getString(cursor.getColumnIndex(KEY_MainCameraDescription))
                proFrontCameraTitle = cursor.getString(cursor.getColumnIndex(KEY_FrantCameraTitle))
                proFrontCameraDescrtion = cursor.getString(cursor.getColumnIndex(KEY_FrantCameraDescription))
                proGamingGpuTitle = cursor.getString(cursor.getColumnIndex(KEY_GamingGpuTitle))
                proGamingGpuDescrtion = cursor.getString(cursor.getColumnIndex(KEY_GamingGpuDescription))
                proNetworkSpeedTitle = cursor.getString(cursor.getColumnIndex(KEY_NetworkSpeedTitle))
                proNetworkSpeedDescrtion = cursor.getString(cursor.getColumnIndex(KEY_NetworkFrequencyDescription))
                proBodyStorageTitle = cursor.getString(cursor.getColumnIndex(KEY_BodyStorageTitle))
                proBodyStorageDescrtion = cursor.getString(cursor.getColumnIndex(KEY_BodyStorageDescription))
                proOperatingSystemTitle =  cursor.getString(cursor.getColumnIndex(KEY_OperatingSystemTitle))
                proOperatingSystemDescrtion = cursor.getString(cursor.getColumnIndex(KEY_OperatingSystemDescription))
                proNetworkFrequencyTitle = cursor.getString(cursor.getColumnIndex( KEY_NetworkFrequencyTitle))
                proNetworkFrequencyDescrtion =  cursor.getString(cursor.getColumnIndex(KEY_NetworkFrequencyDescription))
                proCompanyAccessoryTitle = cursor.getString(cursor.getColumnIndex(KEY_CompanyAccessoryTitle))
                proCompanyAccessoryDescrtion =  cursor.getString(cursor.getColumnIndex(KEY_CompanyAccessoryDescription))
                proConclusionTitle = cursor.getString(cursor.getColumnIndex(KEY_ConclusionTitle))
                proConclusionDescrtion = cursor.getString(cursor.getColumnIndex(KEY_ConclusionDescription))
                proSSD_space = cursor.getString(cursor.getColumnIndex(KEY_SSD_space))
                proWater_proff = cursor.getString(cursor.getColumnIndex(KEY_Water_proff))
                proPrice = cursor.getString(cursor.getColumnIndex(KEY_Price))
                proCheck = cursor.getString(cursor.getColumnIndex(KEY_Check)).toBoolean()
                val pro = ProductAttributes(
                    id = proId,
                    name = proName,
                    descripations = proDescripations,
                    frantImage = proFrantImage,
                    backImage = proBackImage,
                    ramTitle = proRamTitle,
                    ramDetails = proRamDescription,
                    ramEg = proRamEG,
                    displayTitle = proDisplayTitle,
                    displayDiscription = proDisplayDescription,
                    proccesor = proProccesor,
                    mainCameraTitle = proMainCameraTitle,
                    mainCameraDiscription = proMainCameraDescription,
                    frontCameraTitle = proFrontCameraTitle,
                    frontCameraDiscription = proFrontCameraDescrtion,
                    gamingGpuTitle = proGamingGpuTitle,
                    gamingGpuDiscription = proGamingGpuDescrtion,
                    networkSpeedTitle = proNetworkSpeedTitle,
                    networkSpeedDiscription = proNetworkSpeedDescrtion,
                    bodyStroageTitle = proBodyStorageTitle,
                    bodyStroageDiscription = proBodyStorageDescrtion,
                    operatingSystemTitle = proOperatingSystemTitle,
                    operatingSystemDiscription = proOperatingSystemDescrtion,
                    networkFrequencyTitle = proNetworkFrequencyTitle,
                    networkFrequencyDiscription = proNetworkFrequencyDescrtion,
                    companyAccessoryTitle = proCompanyAccessoryTitle,
                    companyAccessoryDiscription = proCompanyAccessoryDescrtion,
                    conclusionTitle = proConclusionTitle,
                    conclusionDiscription = proConclusionDescrtion,
                    ssd_space = proSSD_space,
                    water_proff = proWater_proff,
                    price = proPrice,
                    check = proCheck
                )
                prolist.add(pro)
            } while (cursor.moveToNext())
        }

        return prolist
    }
    @SuppressLint("Range")
    fun getMobileDataDetails(): MutableList<ProductAttributes> {
        val prolist = mutableListOf<ProductAttributes>()
        val selectQuery = "SELECT  * FROM $TABLE_CONTACTS Where id=1"
        val db = this.readableDatabase
        var cursor: Cursor? = null
        try {
            cursor = db.rawQuery(selectQuery, null)
        } catch (e: SQLiteException) {
            db.execSQL(selectQuery)
            return ArrayList()
        }
        var proId: Int
        var proName: String
        var proDescripations: String
        var proFrantImage: String
        var proBackImage: String
        var proRamTitle: String
        var proRamDescription: String
        var proRamEG: String
        var proDisplayTitle: String
        var proDisplayDescription: String
        var proProccesor: String
        var proMainCameraTitle: String
        var proMainCameraDescription: String
        var proFrontCameraTitle: String
        var proFrontCameraDescrtion: String
        var proGamingGpuTitle: String
        var proGamingGpuDescrtion: String
        var proNetworkSpeedTitle: String
        var proNetworkSpeedDescrtion: String
        var proBodyStorageTitle: String
        var proBodyStorageDescrtion: String
        var proOperatingSystemTitle: String
        var proOperatingSystemDescrtion: String
        var proNetworkFrequencyTitle: String
        var proNetworkFrequencyDescrtion: String
        var proCompanyAccessoryTitle: String
        var proCompanyAccessoryDescrtion: String
        var proConclusionTitle: String
        var proConclusionDescrtion: String
        var proWater_proff: String
        var proSSD_space: String
        var proPrice: String
        var proCheck: Boolean
        if (cursor.moveToFirst()) {
            do {
                proId = cursor.getInt(cursor.getColumnIndex(KEY_ID))
                proName = cursor.getString(cursor.getColumnIndex(KEY_Name))
                proDescripations = cursor.getString(cursor.getColumnIndex(KEY_Descripations))
                proFrantImage = cursor.getString(cursor.getColumnIndex(KEY_FrantImage))
                proBackImage = cursor.getString(cursor.getColumnIndex(KEY_BackImage))
                proRamTitle = cursor.getString(cursor.getColumnIndex(KEY_RAMTitle))
                proRamDescription = cursor.getString(cursor.getColumnIndex(KEY_Descripations))
                proRamEG = cursor.getString(cursor.getColumnIndex(KEY_RAMEG))
                proDisplayTitle = cursor.getString(cursor.getColumnIndex(KEY_DisplayTitle))
                proDisplayDescription = cursor.getString(cursor.getColumnIndex(KEY_DisplayDescription))
                proProccesor = cursor.getString(cursor.getColumnIndex(KEY_Mobile_Proccesor))
                proMainCameraTitle = cursor.getString(cursor.getColumnIndex(KEY_MainCameraTitle))
                proMainCameraDescription = cursor.getString(cursor.getColumnIndex(KEY_MainCameraDescription))
                proFrontCameraTitle = cursor.getString(cursor.getColumnIndex(KEY_FrantCameraTitle))
                proFrontCameraDescrtion = cursor.getString(cursor.getColumnIndex(KEY_FrantCameraDescription))
                proGamingGpuTitle = cursor.getString(cursor.getColumnIndex(KEY_GamingGpuTitle))
                proGamingGpuDescrtion = cursor.getString(cursor.getColumnIndex(KEY_GamingGpuDescription))
                proNetworkSpeedTitle = cursor.getString(cursor.getColumnIndex(KEY_NetworkSpeedTitle))
                proNetworkSpeedDescrtion = cursor.getString(cursor.getColumnIndex(KEY_NetworkFrequencyDescription))
                proBodyStorageTitle = cursor.getString(cursor.getColumnIndex(KEY_BodyStorageTitle))
                proBodyStorageDescrtion = cursor.getString(cursor.getColumnIndex(KEY_BodyStorageDescription))
                proOperatingSystemTitle =  cursor.getString(cursor.getColumnIndex(KEY_OperatingSystemTitle))
                proOperatingSystemDescrtion = cursor.getString(cursor.getColumnIndex(KEY_OperatingSystemDescription))
                proNetworkFrequencyTitle = cursor.getString(cursor.getColumnIndex( KEY_NetworkFrequencyTitle))
                proNetworkFrequencyDescrtion =  cursor.getString(cursor.getColumnIndex(KEY_NetworkFrequencyDescription))
                proCompanyAccessoryTitle = cursor.getString(cursor.getColumnIndex(KEY_CompanyAccessoryTitle))
                proCompanyAccessoryDescrtion =  cursor.getString(cursor.getColumnIndex(KEY_CompanyAccessoryDescription))
                proConclusionTitle = cursor.getString(cursor.getColumnIndex(KEY_ConclusionTitle))
                proConclusionDescrtion = cursor.getString(cursor.getColumnIndex(KEY_ConclusionDescription))
                proSSD_space = cursor.getString(cursor.getColumnIndex(KEY_SSD_space))
                proWater_proff = cursor.getString(cursor.getColumnIndex(KEY_Water_proff))
                proPrice = cursor.getString(cursor.getColumnIndex(KEY_Price))
                proCheck = cursor.getString(cursor.getColumnIndex(KEY_Check)).toBoolean()
                val pro = ProductAttributes(
                    id = proId,
                    name = proName,
                    descripations = proDescripations,
                    frantImage = proFrantImage,
                    backImage = proBackImage,
                    ramTitle = proRamTitle,
                    ramDetails = proRamDescription,
                    ramEg = proRamEG,
                    displayTitle = proDisplayTitle,
                    displayDiscription = proDisplayDescription,
                    proccesor = proProccesor,
                    mainCameraTitle = proMainCameraTitle,
                    mainCameraDiscription = proMainCameraDescription,
                    frontCameraTitle = proFrontCameraTitle,
                    frontCameraDiscription = proFrontCameraDescrtion,
                    gamingGpuTitle = proGamingGpuTitle,
                    gamingGpuDiscription = proGamingGpuDescrtion,
                    networkSpeedTitle = proNetworkSpeedTitle,
                    networkSpeedDiscription = proNetworkSpeedDescrtion,
                    bodyStroageTitle = proBodyStorageTitle,
                    bodyStroageDiscription = proBodyStorageDescrtion,
                    operatingSystemTitle = proOperatingSystemTitle,
                    operatingSystemDiscription = proOperatingSystemDescrtion,
                    networkFrequencyTitle = proNetworkFrequencyTitle,
                    networkFrequencyDiscription = proNetworkFrequencyDescrtion,
                    companyAccessoryTitle = proCompanyAccessoryTitle,
                    companyAccessoryDiscription = proCompanyAccessoryDescrtion,
                    conclusionTitle = proConclusionTitle,
                    conclusionDiscription = proConclusionDescrtion,
                    ssd_space = proSSD_space,
                    water_proff = proWater_proff,
                    price = proPrice,
                    check = proCheck
                )
                prolist.add(pro)
            } while (cursor.moveToNext())
        }

        return prolist
    }

    //method to update data
    fun updatePeoduct(pro: ProductAttributes): Int {
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(KEY_ID, pro.id)
        contentValues.put(KEY_Name, pro.name) // EmpModelClass Email
        // Updating Row  
        val success = db.update(TABLE_CONTACTS, contentValues, "id=" + pro.id, null)
        //2nd argument is String containing nullColumnHack  
        db.close() // Closing database connection  
        return success
    }

    //method to delete data  
    fun deleteEmployee(pro: ProductAttributes): Int {
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(KEY_ID, pro.id) // EmpModelClass UserId  
        // Deleting Row  
        val success = db.delete(TABLE_CONTACTS, "id=" + pro.id, null)
        //2nd argument is String containing nullColumnHack  
        db.close() // Closing database connection  
        return success
    }

    fun deleteAll() {
        val db = this.writableDatabase
        val success = db.execSQL("delete from " + TABLE_CONTACTS)
        db.close()
        return success
    }


} 