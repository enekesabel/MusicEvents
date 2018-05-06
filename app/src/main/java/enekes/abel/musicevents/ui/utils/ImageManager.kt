package enekes.abel.musicevents.ui.utils

import android.content.Context
import android.content.ContextWrapper
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.widget.ImageView
import com.squareup.picasso.Picasso
import com.squareup.picasso.Target
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.lang.Exception

class ImageManager(private val context: Context, private val imageDir: String) {

    private fun picassoImageTarget(context: Context, imageDir: String, imageName: String): com.squareup.picasso.Target {
        val cw = ContextWrapper(context)
        val directory = cw.getDir(imageDir, Context.MODE_PRIVATE) // path to /data/data/yourapp/app_imageDir
        return object : Target {

            override fun onBitmapLoaded(bitmap: Bitmap, from: Picasso.LoadedFrom) {
                Thread(Runnable {
                    val myImageFile = File(directory, imageName) // Create image file
                    var fos: FileOutputStream? = null
                    try {
                        fos = FileOutputStream(myImageFile)
                        bitmap.compress(Bitmap.CompressFormat.PNG, 100, fos)
                    } catch (e: IOException) {
                        e.printStackTrace()
                    } finally {
                        try {
                            fos!!.close()
                        } catch (e: IOException) {
                            e.printStackTrace()
                        }

                    }
                }).start()
            }

            override fun onBitmapFailed(e: Exception?, errorDrawable: Drawable?) {}
            override fun onPrepareLoad(placeHolderDrawable: Drawable?) {
                if (placeHolderDrawable != null) {
                }
            }
        }
    }

    fun loadImageFromUrl(url: String, imageView: ImageView){
        Picasso.get().load(url).into(imageView)
    }

    fun loadImageFromFile(imageFileName: String, imageView: ImageView) {
        val cw = ContextWrapper(context)
        val directory = cw.getDir(imageDir, Context.MODE_PRIVATE)
        val myImageFile = File(directory, imageFileName)
        Picasso.get().load(myImageFile).into(imageView)
    }

    fun downloadAndSave(url: String, imageName: String) {
        Picasso.get().load(url).into(picassoImageTarget(context, imageDir, imageName))
    }
}