package de.fhkl.gatav_project;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

import javax.microedition.khronos.opengles.GL10;

public class Cubes {
	private FloatBuffer frontVertexBuffer;

	private FloatBuffer rightVertexBuffer;
	private FloatBuffer rightColorBuffer;

	private FloatBuffer topVertexBuffer;
	private FloatBuffer topColorBuffer;
	private ShortBuffer topTopologyBuffer;

	private FloatBuffer leftVertexBuffer;
	private FloatBuffer leftColorBuffer;
	private ShortBuffer leftTopologyBuffer;

	private FloatBuffer backVertexBuffer;
	private FloatBuffer backColorBuffer;
	private ShortBuffer backTopologyBuffer;

	private FloatBuffer bottomVertexBuffer;
	private FloatBuffer bottomColorBuffer;
	private ShortBuffer bottomTopologyBuffer;

	public Cubes() {
		// init shape and color

		// front side, two triangles, without individual color
		// drawArrays
		float geometryFront[] = { -0.5f, 0.5f, 0.5f, // v0
				-0.5f, -0.5f, 0.5f, // v2
				0.5f, 0.5f, 0.5f, // v1
				0.5f, 0.5f, 0.5f, // v1
				-0.5f, -0.5f, 0.5f, // v2
				0.5f, -0.5f, 0.5f }; // v3

		// Buffers to be passed to gl*Pointer() functions
		// must be direct, that means, they must be placed on the
		// native heap where the garbage collector cannot
		// move them
		//
		// Buffers with multi-byte datatypes (e.g., short, int, float)
		// must have their byte order (big oder little endian)
		// set to native order

		ByteBuffer frontVertexBB = ByteBuffer
				.allocateDirect(geometryFront.length * 4);
		frontVertexBB.order(ByteOrder.nativeOrder());
		frontVertexBuffer = frontVertexBB.asFloatBuffer();
		frontVertexBuffer.put(geometryFront);
		frontVertexBuffer.position(0);

		// right side, two triangles, with individual vertex color
		// drawArrays
		float geometryRight[] = { 0.5f, 0.5f, 0.5f, // v1
				0.5f, -0.5f, 0.5f, // v3
				0.5f, 0.5f, -0.5f, // v5
				0.5f, -0.5f, 0.5f, // v3
				0.5f, -0.5f, -0.5f, // v7
				0.5f, 0.5f, -0.5f }; // v5
		float colorRight[] = { 1.0f, 0.0f, 0.0f, 0.0f, // v1
				0.0f, 1.0f, 0.0f, 0.0f, // v3
				0.0f, 0.0f, 1.0f, 0.0f, // v5
				0.0f, 1.0f, 0.0f, 0.0f, // v3
				1.0f, 1.0f, 1.0f, 0.0f, // v7
				0.0f, 0.0f, 1.0f, 0.0f }; // v5

		ByteBuffer rightVertexBB = ByteBuffer
				.allocateDirect(geometryRight.length * 4);
		rightVertexBB.order(ByteOrder.nativeOrder());
		rightVertexBuffer = rightVertexBB.asFloatBuffer();
		rightVertexBuffer.put(geometryRight);
		rightVertexBuffer.position(0);

		ByteBuffer rightColorBB = ByteBuffer
				.allocateDirect(colorRight.length * 4);
		rightColorBB.order(ByteOrder.nativeOrder());
		rightColorBuffer = rightColorBB.asFloatBuffer();
		rightColorBuffer.put(colorRight);
		rightColorBuffer.position(0);

		// top side, two triangles, with individual vertex color
		// drawElements using topology
		float geometryTop[] = { -0.5f, 0.5f, -0.5f, // v4
				0.5f, 0.5f, -0.5f, // v5
				-0.5f, 0.5f, 0.5f, // v0
				0.5f, 0.5f, 0.5f }; // v1
		float colorTop[] = { 0.0f, 0.0f, 1.0f, 0.0f, // v4
				1.0f, 1.0f, 1.0f, 0.0f, // v5
				1.0f, 0.0f, 0.0f, 0.0f, // v0
				0.0f, 1.0f, 0.0f, 0.0f }; // v1
		short topologyTop[] = { 2, 3, 0, // v0, v1, v4
				3, 1, 0 }; // v1, v5, v4

		ByteBuffer topVertexBB = ByteBuffer
				.allocateDirect(geometryTop.length * 4);
		topVertexBB.order(ByteOrder.nativeOrder());
		topVertexBuffer = topVertexBB.asFloatBuffer();
		topVertexBuffer.put(geometryTop);
		topVertexBuffer.position(0);

		ByteBuffer topColorBB = ByteBuffer.allocateDirect(colorTop.length * 4);
		topColorBB.order(ByteOrder.nativeOrder());
		topColorBuffer = topColorBB.asFloatBuffer();
		topColorBuffer.put(colorTop);
		topColorBuffer.position(0);

		ByteBuffer topTopologyBB = ByteBuffer
				.allocateDirect(topologyTop.length * 2);
		topTopologyBB.order(ByteOrder.nativeOrder());
		topTopologyBuffer = topTopologyBB.asShortBuffer();
		topTopologyBuffer.put(topologyTop);
		topTopologyBuffer.position(0);

		// left side, two triangles, with individual vertex color
		// drawElements using topology
		float geometryLeft[] = { -0.5f, 0.5f, 0.5f, // v0
				-0.5f, 0.5f, -0.5f, // v4
				-0.5f, -0.5f, -0.5f, // v6
				-0.5f, -0.5f, 0.5f }; // v2

		float colorLeft[] = { 1.0f, 0.0f, 0.0f, 0.0f, // v0
				0.0f, 0.0f, 1.0f, 0.0f, // v4
				0.0f, 0.0f, 0.0f, 0.0f, // v6
				0.0f, 1.0f, 0.0f, 0.0f }; // v2

		short topologyLeft[] = { 0, 1, 3, // v0, v4, v2
				1, 2, 3 }; // v4, v2, v6

		ByteBuffer leftVertexBB = ByteBuffer
				.allocateDirect(geometryLeft.length * 4);
		leftVertexBB.order(ByteOrder.nativeOrder());
		leftVertexBuffer = leftVertexBB.asFloatBuffer();
		leftVertexBuffer.put(geometryLeft);
		leftVertexBuffer.position(0);

		ByteBuffer leftColorBB = ByteBuffer
				.allocateDirect(colorLeft.length * 4);
		leftColorBB.order(ByteOrder.nativeOrder());
		leftColorBuffer = leftColorBB.asFloatBuffer();
		leftColorBuffer.put(colorLeft);
		leftColorBuffer.position(0);

		ByteBuffer leftTopologyBB = ByteBuffer
				.allocateDirect(topologyLeft.length * 2);
		leftTopologyBB.order(ByteOrder.nativeOrder());
		leftTopologyBuffer = leftTopologyBB.asShortBuffer();
		leftTopologyBuffer.put(topologyLeft);
		leftTopologyBuffer.position(0);

		// back side, two triangles, with individual vertex color
		// drawElements using topology
		float geometryBack[] = { -0.5f, 0.5f, -0.5f, // v4
				0.5f, 0.5f, -0.5f, // v5
				0.5f, -0.5f, -0.5f, // v7
				-0.5f, -0.5f, -0.5f }; // v6

		float colorBack[] = { 0.0f, 0.0f, 1.0f, 0.0f, // v4
				0.0f, 0.0f, 1.0f, 0.0f, // v5
				0.0f, 0.0f, 0.0f, 0.0f, // v7
				0.0f, 1.0f, 0.0f, 0.0f }; // v6

		short topologyBack[] = { 0, 1, 3, // v0, v4, v2
				1, 2, 3 }; // v4, v2, v6

		ByteBuffer backVertexBB = ByteBuffer
				.allocateDirect(geometryLeft.length * 4);
		backVertexBB.order(ByteOrder.nativeOrder());
		backVertexBuffer = backVertexBB.asFloatBuffer();
		backVertexBuffer.put(geometryBack);
		backVertexBuffer.position(0);

		ByteBuffer backColorBB = ByteBuffer
				.allocateDirect(colorLeft.length * 4);
		backColorBB.order(ByteOrder.nativeOrder());
		backColorBuffer = backColorBB.asFloatBuffer();
		backColorBuffer.put(colorBack);
		backColorBuffer.position(0);

		ByteBuffer backTopologyBB = ByteBuffer
				.allocateDirect(topologyLeft.length * 2);
		backTopologyBB.order(ByteOrder.nativeOrder());
		backTopologyBuffer = backTopologyBB.asShortBuffer();
		backTopologyBuffer.put(topologyBack);
		backTopologyBuffer.position(0);

		// bottom side, two triangles, with individual vertex color
		// drawElements using topology
		float geometryBottom[] = { -0.5f, -0.5f, -0.5f, // v6
				0.5f, -0.5f, -0.5f, // v7
				0.5f, -0.5f, 0.5f, // v3
				-0.5f, -0.5f, 0.5f }; // v2

		float colorBottom[] = { 0.0f, 1.0f, 0.0f, 0.0f, // v6
				0.0f, 0.0f, 0.0f, 1.0f, // v7
				0.0f, 1.0f, 0.0f, 0.0f, // v3
				0.0f, 1.0f, 0.0f, 0.0f }; // v2

		short topologyBottom[] = { 0, 1, 3, // v0, v4, v2
				1, 2, 3 }; // v4, v2, v6

		ByteBuffer bottomVertexBB = ByteBuffer
				.allocateDirect(geometryLeft.length * 4);
		bottomVertexBB.order(ByteOrder.nativeOrder());
		bottomVertexBuffer = bottomVertexBB.asFloatBuffer();
		bottomVertexBuffer.put(geometryBottom);
		bottomVertexBuffer.position(0);

		ByteBuffer bottomColorBB = ByteBuffer
				.allocateDirect(colorBottom.length * 4);
		bottomColorBB.order(ByteOrder.nativeOrder());
		bottomColorBuffer = bottomColorBB.asFloatBuffer();
		bottomColorBuffer.put(colorBottom);
		bottomColorBuffer.position(0);

		ByteBuffer bottomTopologyBB = ByteBuffer
				.allocateDirect(topologyBottom.length * 2);
		bottomTopologyBB.order(ByteOrder.nativeOrder());
		bottomTopologyBuffer = bottomTopologyBB.asShortBuffer();
		bottomTopologyBuffer.put(topologyBottom);
		bottomTopologyBuffer.position(0);
	}

	public void draw(GL10 gl) {
		// draw front side
		gl.glColor4f(1.0f, 0.0f, 0.0f, 0.0f);
		gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
		gl.glVertexPointer(3, GL10.GL_FLOAT, 0, frontVertexBuffer);
		gl.glDrawArrays(GL10.GL_TRIANGLES, 0, 6);
		gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);

		// draw right side
		gl.glColor4f(1.0f, 0.0f, 0.0f, 0.0f);
		gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
		gl.glEnableClientState(GL10.GL_COLOR_ARRAY);
		gl.glVertexPointer(3, GL10.GL_FLOAT, 0, rightVertexBuffer);
		gl.glColorPointer(4, GL10.GL_FLOAT, 0, rightColorBuffer);
		gl.glDrawArrays(GL10.GL_TRIANGLES, 0, 6);
		gl.glDisableClientState(GL10.GL_COLOR_ARRAY);
		gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);

		// draw top side
		gl.glColor4f(1.0f, 0.0f, 0.0f, 0.0f);
		gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
		gl.glEnableClientState(GL10.GL_COLOR_ARRAY);
		gl.glVertexPointer(3, GL10.GL_FLOAT, 0, topVertexBuffer);
		gl.glColorPointer(4, GL10.GL_FLOAT, 0, topColorBuffer);
		gl.glDrawElements(GL10.GL_TRIANGLES, topTopologyBuffer.limit(),
				GL10.GL_UNSIGNED_SHORT, topTopologyBuffer);
		gl.glDisableClientState(GL10.GL_COLOR_ARRAY);
		gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);

		// draw left side
		gl.glColor4f(1.0f, 0.0f, 0.0f, 0.0f);
		gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
		gl.glEnableClientState(GL10.GL_COLOR_ARRAY);
		gl.glVertexPointer(3, GL10.GL_FLOAT, 0, leftVertexBuffer);
		gl.glColorPointer(4, GL10.GL_FLOAT, 0, leftColorBuffer);
		gl.glDrawElements(GL10.GL_TRIANGLES, leftTopologyBuffer.limit(),
				GL10.GL_UNSIGNED_SHORT, leftTopologyBuffer);
		gl.glDisableClientState(GL10.GL_COLOR_ARRAY);
		gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);

		// draw back side
		gl.glColor4f(1.0f, 0.0f, 0.0f, 0.0f);
		gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
		gl.glEnableClientState(GL10.GL_COLOR_ARRAY);
		gl.glVertexPointer(3, GL10.GL_FLOAT, 0, backVertexBuffer);
		gl.glColorPointer(4, GL10.GL_FLOAT, 0, backColorBuffer);
		gl.glDrawElements(GL10.GL_TRIANGLES, backTopologyBuffer.limit(),
				GL10.GL_UNSIGNED_SHORT, backTopologyBuffer);
		gl.glDisableClientState(GL10.GL_COLOR_ARRAY);
		gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);

		// draw bottom side
		gl.glColor4f(1.0f, 0.0f, 0.0f, 0.0f);
		gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
		gl.glEnableClientState(GL10.GL_COLOR_ARRAY);
		gl.glVertexPointer(3, GL10.GL_FLOAT, 0, bottomVertexBuffer);
		gl.glColorPointer(4, GL10.GL_FLOAT, 0, bottomColorBuffer);
		gl.glDrawElements(GL10.GL_TRIANGLES, bottomTopologyBuffer.limit(),
				GL10.GL_UNSIGNED_SHORT, bottomTopologyBuffer);
		gl.glDisableClientState(GL10.GL_COLOR_ARRAY);
		gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
	}
}
