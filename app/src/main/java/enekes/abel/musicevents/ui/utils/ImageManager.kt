package enekes.abel.musicevents.ui.utils

import android.content.Context
import android.content.ContextWrapper
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.os.Handler
import android.widget.ImageView
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import com.squareup.picasso.Target
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.lang.Exception
import android.os.Looper

class ImageManager(private val context: Context, private val imageDir: String) {

    private fun picassoImageTarget(context: Context, imageDir: String, imageName: String, callback: Callback): com.squareup.picasso.Target {
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
                        callback.onSuccess()
                    } catch (e: IOException) {
                        e.printStackTrace()
                        callback.onError(e)
                    } finally {
                        try {
                            fos!!.close()
                        } catch (e: IOException) {
                            e.printStackTrace()
                        }

                    }
                }).start()
            }

            override fun onBitmapFailed(e: Exception?, errorDrawable: Drawable?) {
                callback.onError(e)
            }

            override fun onPrepareLoad(placeHolderDrawable: Drawable?) {
                if (placeHolderDrawable != null) {
                }
            }
        }
    }

    fun loadImageFromUrl(url: String, imageView: ImageView, callback: Callback) {
        val uiHandler = Handler(Looper.getMainLooper())
        uiHandler.post({
            Picasso.get().load(url).into(imageView, callback)
        })
    }

    fun loadImageFromFile(imageFileName: String, imageView: ImageView, callback: Callback) {
        val cw = ContextWrapper(context)
        val directory = cw.getDir(imageDir, Context.MODE_PRIVATE)
        val myImageFile = File(directory, imageFileName)

        val uiHandler = Handler(Looper.getMainLooper())
        uiHandler.post({
            Picasso.get().load(myImageFile).into(imageView, callback)
        })
    }

    fun downloadAndSave(url: String, imageName: String, callback: Callback) {
        val uiHandler = Handler(Looper.getMainLooper())
        uiHandler.post({
            Picasso.get().load(url).into(picassoImageTarget(context, imageDir, imageName, callback))
        })
    }

}